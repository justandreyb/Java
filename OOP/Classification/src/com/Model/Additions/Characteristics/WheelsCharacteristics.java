package com.Model.Additions.Characteristics;

import com.Model.Characteristics.Characteristics;

import java.util.HashMap;

public class WheelsCharacteristics extends Characteristics {

    public WheelsCharacteristics() {

        HashMap<String, String> characteristics = new HashMap<>();
        characteristics.put("WheelSize", "-");
        characteristics.put("WheelType", "-");
        this.setCharacteristics(characteristics);
    }

    public WheelsCharacteristics(HashMap<String, String> characteristics) {

        this.setCharacteristics(characteristics);
    }

}