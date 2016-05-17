package com.Model.Additions.Characteristics;

import com.Model.Characteristics.Characteristics;

import java.util.HashMap;

public class SeatsCharacteristics extends Characteristics {

    public SeatsCharacteristics() {

        HashMap<String, String> characteristics = new HashMap<>();
        characteristics.put("SeatsCount", "-");
        this.setCharacteristics(characteristics);
    }

    public SeatsCharacteristics(HashMap<String, String> characteristics) {

        this.setCharacteristics(characteristics);
    }

}