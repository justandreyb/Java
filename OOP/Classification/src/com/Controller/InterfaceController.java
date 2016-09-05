package com.Controller;

import com.Model.Automobile;
import com.Model.Creator;
import com.Model.Serialization;
import com.Model.Utils.FactorySerializators;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class InterfaceController extends Application implements Serializable {

    public Label idManufacturer;
    public Label idModel;
    public Label idPower;
    public Label idYear;
    public Label idAdditionalFirst;
    public Label idAdditionalSecond;
    public Label idAdditionalThird;
    public Label idAdditionalFourth;
    public Label idTYPE;

    public Button btnSelect;

    Stage primaryStage;
    Scene rootScene;

    public MenuItem btnClose;
    public MenuItem btnAbout;
    public MenuItem btnSaveSelected;
    public MenuItem btnOpenCreated;

    public Button btnAdd;
    public Button btnEdit;
    public Button btnDelete;

    public ListView automobilesList;
    public ArrayList automobilesArray;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("../View/Interface.fxml"));
        primaryStage.setTitle("Automobile classification");
        primaryStage.setScene(rootScene = new Scene(root, 600, 400));
        primaryStage.show();

        automobilesList = new ListView();
        automobilesArray = new ArrayList<>();

    }


    public String showChoiceDialog() {

        final String[] answer = {new String()};

        List<String> choices = new ArrayList<>();
        choices.add("Sport");
        choices.add("Standart");
        choices.add("Specialized");
        choices.add("Van");
        choices.add("City");
        choices.add("Intercity");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Sport", choices);
        dialog.setTitle("Choice Automobile");
        dialog.setHeaderText("Here you can choice new automobile");
        dialog.setContentText("Choose automobile:");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()){
            System.out.println("Your choice: " + result.get());
        }

        result.ifPresent(newAutomobile -> answer[0] = newAutomobile );

        return answer[0];
    }

    public boolean showAutomobileEditDialog(Automobile automobile) {

        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(InterfaceController.class.getResource("../View/EditCurrentAutomobileCharacteristics.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Set automobile characteristics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            EditFormController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setAutomobile(automobile);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

            controller.setAutomobile(automobile);

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addNewAutomobile(ActionEvent actionEvent) throws Exception {
        try {
            Creator creator = new Creator();
            Automobile currentAutomobile = creator.getAutomobile(showChoiceDialog());
            if (currentAutomobile != null) {

                automobilesList.getItems().add(currentAutomobile);
                int currentIndex = automobilesList.getItems().indexOf(currentAutomobile);


                showAutomobileDetails(currentAutomobile);
            }
        }
        catch (Exception ex) {

        }
    }

    public void editCurrentAutomobile(ActionEvent actionEvent) throws ClassNotFoundException {

        Automobile selectedAutomobile = (Automobile) automobilesList.getSelectionModel().getSelectedItem();
        int selectedIndex = automobilesList.getSelectionModel().getSelectedIndex();
        if (selectedAutomobile != null) {
            boolean okClicked = showAutomobileEditDialog(selectedAutomobile);
            if (okClicked) {
                automobilesList.getItems().remove(selectedIndex);
                automobilesList.getItems().add(selectedIndex, selectedAutomobile);

                showAutomobileDetails(selectedAutomobile);
            }

        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Automobile Selected");
            alert.setContentText("Please select automobile in the table.");

            alert.showAndWait();
        }

    }

    public void deleteCurrentAutomobile(ActionEvent actionEvent) {

        int selectedIndex = automobilesList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            automobilesList.getItems().remove(selectedIndex);

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Automobile Selected");
            alert.setContentText("Please select a automobile in the table.");

            alert.showAndWait();
        }
    }

    public ObservableList getAutomobilesData() {
        return automobilesList.getItems();
    }

    private void showAutomobileDetails(Automobile automobile) throws ClassNotFoundException {

        ArrayList characteristics = automobile.getInformation();

        idTYPE.setText(getAutomobileType(automobile));
        idManufacturer.setText((String) characteristics.get(0));
        idModel.setText((String) characteristics.get(1));
        idYear.setText(String.valueOf(characteristics.get(2)));
        idPower.setText(String.valueOf(characteristics.get(3)));

        switch (characteristics.size()) {

            case 5:
                idAdditionalFirst.setText(String.valueOf(characteristics.get(4)));

                idAdditionalSecond.setText("Not set");
                idAdditionalThird.setText("Not set");
                idAdditionalFourth.setText("Not set");
                break;
            case 6:
                idAdditionalFirst.setText(String.valueOf(characteristics.get(4)));
                idAdditionalSecond.setText(String.valueOf(characteristics.get(5)));

                idAdditionalThird.setText("Not set");
                idAdditionalFourth.setText("Not set");
                break;
            case 7:
                idAdditionalFirst.setText(String.valueOf(characteristics.get(4)));
                idAdditionalSecond.setText(String.valueOf(characteristics.get(5)));
                idAdditionalThird.setText(String.valueOf(characteristics.get(6)));

                idAdditionalFourth.setText("Not set");
                break;
            case 8:
                idAdditionalFirst.setText(String.valueOf(characteristics.get(4)));
                idAdditionalSecond.setText(String.valueOf(characteristics.get(5)));
                idAdditionalThird.setText(String.valueOf(characteristics.get(6)));
                idAdditionalFourth.setText(String.valueOf(characteristics.get(7)));
                break;
        }
    }

    public void getAbout(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

        stage.getIcons().add(new Image(this.getClass().getResource("../../img/icoPlusAcc.jpg").toString()));
        alert.setTitle("About me");
        alert.setHeaderText("Information about developer");
        alert.setContentText("justandreyb@gmail.com");

        alert.showAndWait();

    }

    public void clickBtnClose(ActionEvent actionEvent) {

        Platform.exit();

    }

    public void saveCurrentObject(ActionEvent actionEvent) throws Exception {

        if(getAutomobilesData().size() > 0) {

            FactorySerializators factorySerializators = new FactorySerializators();
            final String[] answer = {new String()};

            List<String> choices = new ArrayList<>();
            choices.add("BIN");
            choices.add("XML");
            choices.add("TXT");

            ChoiceDialog<String> dialog = new ChoiceDialog<>("", choices);
            dialog.setTitle("Choice file type");
            dialog.setHeaderText("Here you can choice the type of saving file");
            dialog.setContentText("Choose type:");

            Optional<String> result = dialog.showAndWait();

            if (result.isPresent()){
                System.out.println("Your choice: " + result.get());
            }

            result.ifPresent(newAutomobile -> answer[0] = newAutomobile );

            Serialization serialization = factorySerializators.getSerializator(answer[0]);
            serialization.serializeFile(getAutomobilesData());

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Warning");
            alert.setHeaderText("No automobiles created");
            alert.setContentText("Please first create automobile.");

            alert.showAndWait();
        }
    }

    public void selectCurrentAutomobile(ActionEvent actionEvent) throws ClassNotFoundException {

        if(automobilesList.getSelectionModel().getSelectedItem() != null) {

            Automobile currentSelect = (Automobile) automobilesList.getSelectionModel().getSelectedItem();
            showAutomobileDetails(currentSelect);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Warning");
            alert.setHeaderText("Not selected any cell");
            alert.setContentText("Please, select cell");

            alert.showAndWait();
        }
    }

    public String getAutomobileType(Automobile automobile) throws ClassNotFoundException {
        try {
            HashMap<Class<Automobile>, String> automobiles = new HashMap<>();

            automobiles.put((Class<Automobile>) Class.forName("com.Model.Automobiles.Passenger.Cars.Sport.Sport"), "Sport");
            automobiles.put((Class<Automobile>) Class.forName("com.Model.Automobiles.Passenger.Cars.Standart.Standart"), "Standart");
            automobiles.put((Class<Automobile>) Class.forName("com.Model.Automobiles.Trucks.Specialized.Specialized"), "Specialized");
            automobiles.put((Class<Automobile>) Class.forName("com.Model.Automobiles.Trucks.Vans.Van"), "Van");
            automobiles.put((Class<Automobile>) Class.forName("com.Model.Automobiles.Passenger.Buses.City.City"), "City");
            automobiles.put((Class<Automobile>) Class.forName("com.Model.Automobiles.Passenger.Buses.Intercity.Intercity"), "Intercity");

            return automobiles.get(automobile.getClass());
        }
        catch (Exception ex) {
            new Exception(ex);
            return null;
        }


    }

    public void openCreatedObject(ActionEvent actionEvent) throws Exception {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("BIN/FTF/XML", "*.bin;*.xml;*.txt"),
                new FileChooser.ExtensionFilter("BIN", "*.bin"),
                new FileChooser.ExtensionFilter("FTF", "*.txt"),
                new FileChooser.ExtensionFilter("XML", "*.xml")
        );
//        fileChooser.setInitialDirectory();
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {

            String type = selectedFile.getCanonicalPath();
            type = type.substring(type.length() - 3, type.length());
            System.out.println(type);
            FactorySerializators factorySerializators = new FactorySerializators();
            Serialization serialization = factorySerializators.getSerializator(type.toUpperCase());
            ArrayList arrayList = (ArrayList) serialization.deserializeFile(selectedFile.getAbsolutePath());

            automobilesList.getItems().addAll(arrayList);
        }
    }
}
