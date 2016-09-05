package com.Model;

import java.io.*;
import java.util.*;

public abstract class Automobile implements Serializable {

    private ArrayList characteristics;
    private String manufacturer;
    private String model;
    private int year;
    private int power;

    public Automobile() {

        initialize();
    }

    public void initialize() {

        this.characteristics = new ArrayList();

        setManufacturer("-");
        addCharacteristic(getManufacturer());

        setModel("-");
        addCharacteristic(getModel());

        setYear(0);
        addCharacteristic(getYear());

        setPower(0);
        addCharacteristic(getPower());
    }

    public String getManufacturer() {
        return this.manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return this.model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return this.year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getPower() {
        return this.power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    protected String getName() throws Exception {

        try {
            String name = getManufacturer() + getModel();
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

    public ArrayList getInformation() {

        return this.characteristics;
    }
    public void addCharacteristic (Object characteristic) {
        this.characteristics.add(characteristic);
    }
}
