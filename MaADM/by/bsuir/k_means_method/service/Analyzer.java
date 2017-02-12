package by.bsuir.k_means_method.service;

import by.bsuir.k_means_method.bean.ClassCenter;
import by.bsuir.k_means_method.bean.DrawingArea;
import by.bsuir.k_means_method.bean.Point;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {
    private DrawingArea area;

    public Analyzer() {
    }

    public void setArea(DrawingArea area) {
        this.area = area;
    }

    public boolean createNewCenters() {
        List<ClassCenter> centers = area.getCenters();
        ArrayList<Boolean> results = new ArrayList<Boolean>(centers.size());
        for (ClassCenter center : centers) {
            results.add(createNewCenter(center));
        }

        return results.contains(true);
    }

    private boolean createNewCenter(ClassCenter center) {
        boolean result = true;

        double classX = 0;
        double classY = 0;
        for (Point point : center.getPoints()) {
            classX += point.getX();
            classY += point.getY();
        }
        classX /= center.getPoints().size();
        classY /= center.getPoints().size();

        if ((classX != center.getX()) || (classY != center.getY())) {
            result = true;
        } else {
            result = false;
        }
        center.clear();

        center.setX(classX);
        center.setY(classY);

        return result;
    }

    public void analyzeCenters() {
        List<Point> points = area.getPoints();
        for (Point point : points) {
            ClassCenter center = getNearestCenter(point);

            center.addPoint(point);
        }
    }

    private ClassCenter getNearestCenter(Point point) {
        double minLength = Integer.MAX_VALUE;
        ClassCenter targetCenter = null;
        for (ClassCenter center : area.getCenters()) {
            double currentLength = calculateLength(point, center);
            if (minLength > currentLength) {
                minLength = currentLength;
                targetCenter = center;
            }
        }

        return targetCenter;
    }

    private double calculateLength(Point point, ClassCenter classCenter) {
        double pointX = point.getX();
        double pointY = point.getY();
        double centerX = classCenter.getX();
        double centerY = classCenter.getY();

        return Math.sqrt(Math.pow(centerX - pointX, 2) + Math.pow(centerY - pointY, 2));
    }
}
