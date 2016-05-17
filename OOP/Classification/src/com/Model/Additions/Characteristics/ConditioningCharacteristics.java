package com.Model.Additions.Characteristics;

import com.Model.Characteristics.Characteristics;

import java.util.HashMap;

public class ConditioningCharacteristics extends Characteristics {

    public ConditioningCharacteristics() {

        HashMap<String, String> characteristics = new HashMap<>();
        characteristics.put("ConditioningManufacturer", "-");
        characteristics.put("ConditioningDate", "-");
        this.setCharacteristics(characteristics);
    }

    public ConditioningCharacteristics(HashMap<String, String> characteristics) {

        this.setCharacteristics(characteristics);
    }

}