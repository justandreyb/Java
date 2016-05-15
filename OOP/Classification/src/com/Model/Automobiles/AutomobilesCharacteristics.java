package com.Model.Automobiles;

import com.Model.Characteristics.Characteristics;

import java.util.HashMap;

public class AutomobilesCharacteristics extends Characteristics {

    public AutomobilesCharacteristics() {

        HashMap<String, String> characteristics = new HashMap<>();
        characteristics.put("Manufacturer", "-");
        characteristics.put("Model", "-");
        characteristics.put("Drive", "-");
        characteristics.put("Power", "-");
        characteristics.put("EngineType", "-");
        characteristics.put("AxleCount", "-");

        this.setCharacteristics(characteristics);
    }

    public AutomobilesCharacteristics(HashMap<String, String> characteristics) {

        this.setCharacteristics(characteristics);
    }

}
