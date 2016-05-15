package com.Model.Automobiles.Special;

import com.Model.Automobiles.Automobile;

import java.util.HashMap;

public class Special extends Automobile{

    public static void main(String[] args) throws Exception {
        Automobile car = new Special();

        HashMap<String, String> specialCharacteristics = new HashMap<>();
        specialCharacteristics.put("Manufacturer", "Volkswagen");
        specialCharacteristics.put("Model", "T5");
        specialCharacteristics.put("Drive", "FWD");
        specialCharacteristics.put("Power", "200");
        specialCharacteristics.put("EngineType", "Petrol");
        specialCharacteristics.put("AxleCount", "2");

        car.setAutomobileCharacteristics(specialCharacteristics);

        car.saveObject();

        Automobile newCar = openObject("VolkswagenT5");
        specialCharacteristics.clear();
        specialCharacteristics.put("Manufacturer", "BMW<");
        specialCharacteristics.put("Model", "M/3");
        specialCharacteristics.put("Drive", "RWD");
        specialCharacteristics.put("Power", "300");
        specialCharacteristics.put("EngineType", "Petrol");
        specialCharacteristics.put("AxleCount", "2");

        newCar.setAutomobileCharacteristics(specialCharacteristics);

        newCar.saveObject();
    }
}
