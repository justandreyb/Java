package com.Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class InterfaceController extends Application {

    public Label helloWorld;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("..\\View\\Interface.fxml"));
        primaryStage.setTitle("Hello");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public void getHello(ActionEvent actionEvent) {
        helloWorld.setText("Hello , World !");
    }
}
