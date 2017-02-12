package by.bsuir.k_means_method.controller;

import by.bsuir.k_means_method.FirstLabApp;
import by.bsuir.k_means_method.bean.ClassCenter;
import by.bsuir.k_means_method.bean.DrawingArea;
import by.bsuir.k_means_method.bean.Point;
import by.bsuir.k_means_method.service.Analyzer;
import by.bsuir.k_means_method.service.Drawer;
import by.bsuir.k_means_method.util.Randomize;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;


public class WorkspaceController {
    private static final int MAX_COUNT_OF_POINTS = 200000;
    private static final int MIN_COUNT_OF_POINTS = 1000;
    private static final int MAX_COUNT_OF_CLASSES = 50;
    private static final int MIN_COUNT_OF_CLASSES = 2;

    private FirstLabApp app;
    private DrawingArea area;
    @FXML
    private Canvas paintField;

    @FXML
    private TextField dots;

    @FXML
    private TextField classes;

    @FXML
    private Button buttonPaint;


    @FXML
    private void initialize() {
         area = new DrawingArea(paintField);
    }

    public void setMainApp(FirstLabApp firstLabApp) {
        this.app = firstLabApp;

    }

    @FXML
    private int handlePaint() {
        if (dots.getText().isEmpty() || classes.getText().isEmpty()) {
            showAlert("Empty arguments", "No arguments entered", "Please enter values in fields.");
            return -1;
        }
        int amountOfDots = 0;
        int amountOfClasses = 0;

        Drawer drawer = new Drawer(area);

        Analyzer analyzer = new Analyzer();
        analyzer.setArea(area);

        try {
            amountOfDots = Integer.parseInt(dots.getText());
            amountOfClasses = Integer.parseInt(classes.getText());

            if (!isValid(amountOfDots, amountOfClasses)) {
               showAlert("Invalid arguments",
                       "Entered arguments are too large or too small",
                       "Please enter another arguments.");
               return -1;
            }
            System.out.println("Points : " + amountOfDots);
            System.out.println("Classes : " + amountOfClasses);

            ArrayList<ClassCenter> centers = Randomize.createCenters(amountOfClasses, area.getWidth(), area.getHeight());
            ArrayList<Point> points = Randomize.createPoints(amountOfDots, area.getWidth(), area.getHeight());

            drawer.clear();

            area.setCenters(centers);
            area.setPoints(points);
            analyzer.analyzeCenters();

            //drawer.drawPoints(centers);

            /*boolean targetCenter = true;
            while (targetCenter) {
                targetCenter = analyzer.createNewCenters(centers);
            }*/


            int readyClassesCount = 0;
            while (readyClassesCount != centers.size() + 5) {
                //readyClassesCount = 0;
                if (!analyzer.createNewCenters()) {
                    readyClassesCount++;
                }

                analyzer.analyzeCenters();
            }

            //analyzer.createNewCenters(centers);

            //drawer.clear();
            //analyzer.analyzeCenters(points);
            drawer.drawPoints(centers);
        } catch (ClassCastException ex) {
            showAlert("Invalid arguments",
                    "Entered arguments are invalid",
                    "Please check arguments.");
        }
        return 1;
    }

    private void showAlert(String title, String headerText, String contextText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(app.getPrimaryStage());
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contextText);

        alert.showAndWait();
    }

    private boolean isValid(int amountOfDots, int amountOfClasses) {
        return (amountOfClasses >= MIN_COUNT_OF_CLASSES &&
                amountOfClasses <= MAX_COUNT_OF_CLASSES &&
                amountOfDots >= MIN_COUNT_OF_POINTS  &&
                amountOfDots <= MAX_COUNT_OF_POINTS
        );
    }

}
