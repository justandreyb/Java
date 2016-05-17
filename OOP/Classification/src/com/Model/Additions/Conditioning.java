package com.Model.Additions;

import com.Model.Additions.Characteristics.ConditioningCharacteristics;
import com.Model.Characteristics.Characteristics;

import java.util.HashMap;

public class Conditioning extends Additions {

    public Characteristics characteristics;

    public Conditioning() {

        this.characteristics = new ConditioningCharacteristics();
    }

    public Conditioning(HashMap<String, String> characteristics) {

        this.characteristics = new ConditioningCharacteristics(characteristics);
    }

}