package com.Model.Characteristics;

import java.util.HashMap;

public abstract class Characteristics {

    HashMap<String, String> characteristics = new HashMap<>();

    public Characteristics() {

    }

    public Characteristics(HashMap<String, String> characteristics) {

        this.setCharacteristics(characteristics);
    }

    public void setCharacteristics(HashMap<String, String> characteristics) {

        this.characteristics.clear();
        this.characteristics.putAll(characteristics);
    }

    public void addCharacteristics(HashMap<String, String> characteristics) {

        this.characteristics.putAll(characteristics);
    }

    public void editCharacteristic(String key, String value) {

        if(this.characteristics.containsKey(key)) {

            this.characteristics.replace(key, this.characteristics.get(key), value);
        }
        else
            System.out.println("Can't change : Object doesn't have this characteristic");
    }

    public String getCharacteristic(String key) {

        if(this.characteristics.containsKey(key)) {
            return this.characteristics.get(key);
        }
        else {
            System.out.println("Error : Object doesn't have this characteristic");
            return null;
        }
    }

    public HashMap<String, String> getCharacteristics() throws Exception {

        try {
            return this.characteristics;
        }
        catch (Exception exception) {
            System.out.println("Error : " + exception);
            return null;
        }
    }



}
