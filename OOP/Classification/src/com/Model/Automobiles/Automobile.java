package com.Model.Automobiles;

import java.io.*;
import java.util.HashMap;

public abstract class Automobile implements Serializable {

    protected HashMap<String, String> carCharacteristics = new HashMap<>();

    public Automobile () {
        carCharacteristics.put("Manufacturer", "-");
        carCharacteristics.put("Model", "-");
        carCharacteristics.put("Drive", "-");
        carCharacteristics.put("Power", "-");
        carCharacteristics.put("Manufacturer", "-");
        carCharacteristics.put("Manufacturer", "-");
    }

    public Automobile (HashMap carCharacteristics) {
        this.carCharacteristics.putAll(carCharacteristics);
    }

    public HashMap getInformation() {
        return this.carCharacteristics;
    }

    protected String getName() throws Exception {

        try {
            String name = carCharacteristics.get("Manufacturer") + carCharacteristics.get("Model");
            if (name.contains("\\") || name.contains("/") || name.contains("*") ||
                    name.contains("?") || name.contains("<") ||
                    name.contains(">") || name.contains("|") ||
                    name.contains("\"")) {
                name.replaceAll("[/*?<>|\"]", "");
                if (name.equals(""))
                    name = "untitled";
            }
            return name;
        }
        catch (Exception exception) {
            System.out.println("Error : " + exception);
            return null;
        }
    }

    public void saveObject() throws Exception {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") +
                    "\\SavedObjects\\" + this.getName() + ".out");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.flush();
            objectOutputStream.close();

        }
        catch (Exception exception) {
            System.out.println("Error : " + exception);
        }
    }

    public void openObject(String objectName) throws Exception {

        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") +
                    "\\SavedObjects\\" + objectName + ".out");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this = (Automobile) objectInputStream.readObject();

        }
        catch (Exception exception) {
            System.out.println("Error : " + exception);
        }
    }

}
