package by.bsuir.k_means_method.bean;

import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DrawingArea {
    private static final int AREA_WIDTH = 599;
    private static final int AREA_HEIGHT = 545;

    private Canvas drawingArea;

    private int areaHeight;
    private int areaWidth;

    private List<ClassCenter> centers;
    private List<Point> points;

    public DrawingArea(Canvas paintField) {
        this.drawingArea = paintField;
        this.centers = new LinkedList<ClassCenter>();
        this.points = new ArrayList<Point>();

        areaWidth = AREA_WIDTH;
        areaHeight = AREA_HEIGHT;
    }

    public Canvas getDrawingArea() {
        return drawingArea;
    }

    public void setDrawingArea(Canvas drawingArea) {
        this.drawingArea = drawingArea;
    }

    public List<ClassCenter> getCenters() {
        return centers;
    }

    public void setCenters(List<ClassCenter> centers) {
        this.centers = centers;
    }

    public void addCenter(ClassCenter classCenter) {
        this.centers.add(classCenter);
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void addPoint(Point point) {
        this.points.add(point);
    }

    public int getHeight() {
        return areaHeight;
    }

    public int getWidth() {
        return areaWidth;
    }

    public void setAreaHeight(int areaHeight) {
        this.areaHeight = areaHeight;
    }

    public void setAreaWidth(int areaWidth) {
        this.areaWidth = areaWidth;
    }
}
