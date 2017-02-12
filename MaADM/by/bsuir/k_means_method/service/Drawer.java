package by.bsuir.k_means_method.service;

import by.bsuir.k_means_method.bean.ClassCenter;
import by.bsuir.k_means_method.bean.DrawingArea;
import by.bsuir.k_means_method.bean.Point;
import by.bsuir.k_means_method.util.Randomize;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.util.List;

public class Drawer {
    private DrawingArea area;
    private Canvas canvas;
    private static final Color DEFAULT_COLOR = Color.BLACK;
    private static final double CENTER_HEIGHT = 5;

    public Drawer(DrawingArea area) {
        this.area = area;
        canvas = area.getDrawingArea();
    }

    public void drawPoints(List<ClassCenter> centers) {
        for (ClassCenter center : centers) {
            setRandomColor();
            for (Point point : center.getPoints()) {
                double x = point.getX();
                double y = point.getY();

                drawPoint(x, y);
            }
        }
    }

    public void drawCenters(List<ClassCenter> classCenters) {
        for (ClassCenter center : classCenters) {

            double x = center.getX();
            double y = center.getY();

            drawCenter(x, y);
        }
    }

    public void clear() {
        canvas.getGraphicsContext2D().clearRect(0,0, area.getWidth(), area.getHeight());
    }

    private void drawPoint(double x, double y) {
        canvas.getGraphicsContext2D().strokeLine(x, y, x, y);
    }

    private void drawCenter(double x, double y) {
        canvas.getGraphicsContext2D().strokeRect(x, y, CENTER_HEIGHT, CENTER_HEIGHT);
    }

    public void setPointWidth(double pointWidth) {
        canvas.getGraphicsContext2D().setLineWidth(pointWidth);
    }

    public void setColor(Color color) {
        canvas.getGraphicsContext2D().setStroke(color);
    }

    public void setRandomColor() {
        canvas.getGraphicsContext2D().setStroke(Randomize.getRandomColor());
    }

    public void resetColor() {
        setColor(DEFAULT_COLOR);
    }
}
