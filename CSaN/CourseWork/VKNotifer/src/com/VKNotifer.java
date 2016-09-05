package com;

import com.Controller.WorkplaceController;
import com.Model.VK.Downloader;
import com.Model.VK.QueryToVK;
import com.Model.VK.VkApi;
import com.Model.VK.audio.AudioApi;
import com.Model.VK.audio.Track;
import com.Model.VK.audio.TrackList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VKNotifer extends Application {

    public static final String LOGIN_SUCCESS_PAGE = "blank.html#", LOGIN_FAILURE_PAGE = "blank.html#error";
    private volatile boolean loginSuccess = false, loginFailure = false;
    private String formData = null;

    private Stage primaryStage;
    private BorderPane rootLayout;
    private BorderPane workplaceLayout;

    HashMap<String, URL> fxmlPaths = new HashMap<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("VK - Test app");

        setFXMLPaths();

        initRootLayout();
        initVKConnection();

    }

    public void initRootLayout() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getFXMLPath("RootPage"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

//            initWorkplaceLayout();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public void initWorkplaceLayout() throws IOException, ParseException {

        FXMLLoader loaderWorkplace = new FXMLLoader();
        loaderWorkplace.setLocation(getFXMLPath("Workplace"));
        workplaceLayout = loaderWorkplace.load();

        loaderWorkplace.setController(workplaceController = new WorkplaceController(formData));

    }*/

    public void initVKConnection() throws Exception {

        VkApi VK = new VkApi();
        final WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        webEngine.load(VK.getAuthRequest());
        primaryStage.show();
        webEngine.getLoadWorker().stateProperty().addListener(
                (ov, oldState, newState) -> {
                    if (newState == Worker.State.SUCCEEDED) {
                        changeState(webEngine.getLocation());
                    }
                });

        rootLayout.setCenter(webView);
        primaryStage.show();

        new Thread(() -> {

            while (!loginSuccess && !loginFailure && primaryStage.isShowing()) ;

            if (loginFailure || (!primaryStage.isShowing())) {
                Platform.exit();
            } else {
                try {
                    AudioApi api = new AudioApi(formData);
                    final TrackList tracks = api.getTrackList();
                    final ListView<Track> list = new ListView<>();
                    ObservableList<Track> items = FXCollections.observableArrayList(tracks);
                    list.setItems(items);
                    Label destLabel = new Label("Choose destination directory: ");
                    final TextField dest = new TextField();
                    Button browse = new Button("Browse...");
                    browse.setOnAction(t -> {
                        DirectoryChooser fc = new DirectoryChooser();

                        File dir = fc.showDialog(primaryStage);
                        if (dir != null) {
                            dest.setText(dir.toString());
                        }
                    });
                    HBox browseLayout = new HBox(5);
                    browseLayout.getChildren().addAll(destLabel, dest, browse);
                    final VBox mainLayout = new VBox(8);
                    Button downloadAll = new Button("Download all");
                    final Button cancel = new Button("Cancel");
                    final HBox downloadLayout = new HBox(5);
                    downloadLayout.getChildren().add(downloadAll);
                    downloadLayout.getChildren().add(cancel);
                    cancel.setVisible(false);
                    final ProgressBar current = new ProgressBar();
                    final ProgressBar global = new ProgressBar();
                    current.setPrefWidth(primaryStage.getWidth());
                    global.setPrefWidth(primaryStage.getWidth());
                    current.setVisible(false);
                    global.setVisible(false);
                    final CheckBox artistDir = new CheckBox("Put every artist in it's directory");
                    mainLayout.getChildren().addAll(browseLayout, artistDir, downloadLayout,
                            current, global, list);
                    final Downloader downloader = new Downloader(tracks, current, global);
                    primaryStage.setOnCloseRequest(t -> downloader.stop());
                    downloadAll.setOnAction(t -> {
                        downloader.setDir(new File(dest.getText()));
                        downloader.setArtistDir(artistDir.isSelected());
                        new Thread(downloader).start();
                    });
                    cancel.setOnAction(t -> downloader.stop());
                    Platform.runLater(() -> primaryStage.setScene(new Scene(mainLayout)));
                    ControlsChecker checker = new ControlsChecker(downloader, primaryStage);
                    checker.setCancelButton(cancel);
                    checker.setDownloadButton(downloadAll);
                    checker.setPrimaryStage(primaryStage);
                    checker.setCurrentProgressBar(current);
                    checker.setGlobalProgressBar(global);
                    new Thread(checker).start();
                } catch (Exception ex) {
                    new Exception(ex);
                }
            }
        }).start();
    }

    protected void changeState(String Url) {
        if (Url.contains(LOGIN_FAILURE_PAGE)) {
            loginFailure = true;
        } else if (Url.contains(LOGIN_SUCCESS_PAGE)) {
            loginSuccess = true;
            try {
                this.formData = URLDecoder.decode(Url.substring(Url.indexOf(LOGIN_SUCCESS_PAGE) + LOGIN_SUCCESS_PAGE.length()), "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(VKNotifer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public URL getPathURL(String targetFile) throws MalformedURLException {
        String defaultPath = "file:" +
                System.getProperty("user.dir").replaceAll("[\\\\]", "/") +
                "/src/com/";
        return new URL(defaultPath + targetFile);
    }

    private void setFXMLPaths() throws MalformedURLException {

        this.fxmlPaths.clear();
        addFXMLPath("RootPage");
        addFXMLPath("Workplace");
        addFXMLPath("Audio");
        addFXMLPath("Photos");
        addFXMLPath("Wall");
    }

    public void addFXMLPath(String key) throws MalformedURLException {

        this.fxmlPaths.put(key, getPathURL("View/" + key + ".fxml"));

    }

    private URL getFXMLPath(String targetFile) {
        return this.fxmlPaths.get(targetFile);
    }

    private class ControlsChecker implements Runnable {

        volatile Downloader downloader;
        volatile Stage primaryStage = null;
        Button cancelButton = null;
        Button downloadButton = null;
        ProgressBar current = null;
        ProgressBar global = null;

        public ControlsChecker(Downloader downloader, Stage primaryStage) {
            this.downloader = downloader;
            this.primaryStage = primaryStage;
        }

        public void setCancelButton(Button cancelButton) {
            this.cancelButton = cancelButton;
        }

        public void setDownloadButton(Button downloadButton) {
            this.downloadButton = downloadButton;
        }

        public void setPrimaryStage(Stage primaryStage) {
            this.primaryStage = primaryStage;
        }

        public void setCurrentProgressBar(ProgressBar current) {
            this.current = current;
        }

        public void setGlobalProgressBar(ProgressBar global) {
            this.global = global;
        }

        @Override
        public void run() {
            boolean running = downloader.isRunning();
            ReadOnlyBooleanProperty stageShowing = primaryStage.showingProperty();
            while (stageShowing.getValue()) {
                while (running == downloader.isRunning() && stageShowing.getValue());
                running = downloader.isRunning();
                if (running) {
                    setVisible(cancelButton, true);
                    setVisible(downloadButton, false);
                    setVisible(current, true);
                    setVisible(global, true);
                } else {
                    setVisible(cancelButton, false);
                    setVisible(downloadButton, true);
                    setVisible(current, false);
                }
            }
        }

        public void setVisible(final Node node, final boolean visible) {
            if (node != null) {
                Platform.runLater(() -> node.setVisible(visible));
            }
        }
    }

}