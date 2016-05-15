package com.Model.Additions.Characteristics;

import com.Model.Characteristics.Characteristics;

import java.util.HashMap;

public class CageCharacteristics extends Characteristics {

    public CageCharacteristics() {

        HashMap<String, String> characteristics = new HashMap<>();
        characteristics.put("Manufacturer", "-");
        characteristics.put("Validity", "-");
        this.setCharacteristics(characteristics);
    }

    public CageCharacteristics(HashMap<String, String> characteristics) {

        this.setCharacteristics(characteristics);
    }

}
