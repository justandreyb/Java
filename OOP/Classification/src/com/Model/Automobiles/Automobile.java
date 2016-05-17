package com.Model.Automobiles;

import com.Model.Characteristics.Characteristics;

import java.io.*;
import java.util.HashMap;

public abstract class Automobile implements Serializable {

    public Characteristics characteristics;

    public Automobile() {

        this.characteristics = new AutomobilesCharacteristics();
    }

    public Automobile(HashMap<String, String> characteristics) {

        this.characteristics = new AutomobilesCharacteristics(characteristics);
    }

    protected String getName() throws Exception {

        try {
            String name = characteristics.getCharacteristic("Manufacturer") + characteristics.getCharacteristic("Model");
            if (name.contains("\\") || name.contains("/") || name.contains("*") ||
                    name.contains("?") || name.contains("<") ||
                    name.contains(">") || name.contains("|") ||
                    name.contains("\"")) {
                name = name.replaceAll("[/*?<>|\"]", "");
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

    public static Automobile openObject(String objectName) throws Exception {

        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") +
                    "\\SavedObjects\\" + objectName + ".out");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Automobile) objectInputStream.readObject();

        }
        catch (Exception exception) {
            System.out.println("Error : " + exception);
            return null;
        }
    }

    public void getInformation() {
        //Get all info
    }

}
