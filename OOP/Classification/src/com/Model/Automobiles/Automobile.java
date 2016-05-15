package com.Model.Automobiles;

import java.io.*;
import java.util.HashMap;

public abstract class Automobile implements Serializable {

    protected HashMap<String, String> automobileCharacteristics = new HashMap<>();

    public Automobile() {

        automobileCharacteristics.put("Manufacturer", "-");
        automobileCharacteristics.put("Model", "-");
        automobileCharacteristics.put("Drive", "-");
        automobileCharacteristics.put("Power", "-");
        automobileCharacteristics.put("EngineType", "-");
        automobileCharacteristics.put("AxleCount", "-");
    }

    public Automobile(HashMap<String, String> automobileCharacteristics) {

        setAutomobileCharacteristics(automobileCharacteristics);
    }

    public HashMap getAutomobileCharacteristics() {

        return this.automobileCharacteristics;
    }

    public void setAutomobileCharacteristics(HashMap<String, String> automobileCharacteristics) {

        this.automobileCharacteristics.putAll(automobileCharacteristics);
    }

    public void showAutomobileCharacteristics(/*Variant : HashMap<String, String> automobileCharacteristics*/) {

        /*Print characteristics in table*/
    }

    protected String getName() throws Exception {

        try {
            String name = automobileCharacteristics.get("Manufacturer") + automobileCharacteristics.get("Model");
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

}
