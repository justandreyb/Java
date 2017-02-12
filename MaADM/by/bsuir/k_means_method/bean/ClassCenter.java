package by.bsuir.k_means_method.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClassCenter {
    private double x;
    private double y;
    private List<Point> points;

    public ClassCenter() {
        points = new LinkedList<Point>();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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

    public void clear() {
        this.points = new ArrayList<Point>(0);
    }
}
