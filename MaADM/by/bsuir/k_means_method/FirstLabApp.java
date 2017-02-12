package by.bsuir.k_means_method;

import by.bsuir.k_means_method.controller.WorkspaceController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstLabApp extends Application {
    private static final String VIEW_PATH = "view/";

    private Stage primaryStage;
    private BorderPane root;

    public FirstLabApp() {

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("K-Means method");

        initRootLayout();

        showWorkspace();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FirstLabApp.class.getResource(VIEW_PATH + "root.fxml"));
            root = (BorderPane) loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showWorkspace() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FirstLabApp.class.getResource(VIEW_PATH + "workspace.fxml"));
            AnchorPane workspacePane = (AnchorPane) loader.load();

            root.setCenter(workspacePane);

            WorkspaceController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
