package by.bsuir.k_means_method.util;

import by.bsuir.k_means_method.bean.ClassCenter;
import by.bsuir.k_means_method.bean.Point;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Randomize {
    private static final Random random = new Random();

    public static int getRandomInt(int max) {
        return random.nextInt(max);
    }

    public static Color getRandomColor() {
        Color color;
        switch (random.nextInt(10)) {
            case 1:
                color = Color.BLACK;
                break;
            case 2:
                color = Color.BLUE;
                break;
            case 3:
                color = Color.BROWN;
                break;
            case 4:
                color = Color.ORANGE;
                break;
            case 5:
                color = Color.OLIVE;
                break;
            case 6:
                color = Color.DARKBLUE;
                break;
            case 7:
                color = Color.GOLD;
                break;
            case 8:
                color = Color.GREEN;
                break;
            case 9:
                color = Color.GRAY;
                break;
            default:
                color = Color.RED;
                break;
        }
        return color;
    }

    public static ArrayList<Point> createPoints(int amount, int maxWidth, int maxHeight) {
        ArrayList<Point> points = new ArrayList<Point>(amount);
        Point point;
        for (int index = 0; index < amount; index++) {
            point = new Point();

            point.setX(Randomize.getRandomInt(maxWidth));
            point.setY(Randomize.getRandomInt(maxHeight));

            points.add(point);
        }

        return points;
    }

    public static ArrayList<ClassCenter> createCenters(int amount, int maxWidth, int maxHeight) {
        ArrayList<ClassCenter> centers = new ArrayList<ClassCenter>(amount);
        ClassCenter center;
        for (int index = 0; index < amount; index++) {
            center = new ClassCenter();

            center.setX(Randomize.getRandomInt(maxWidth));
            center.setY(Randomize.getRandomInt(maxHeight));

            centers.add(center);
        }

        return centers;
    }
}
