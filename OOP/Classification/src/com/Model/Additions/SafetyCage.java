package com.Model.Additions;

import java.util.HashMap;

import com.Model.Additions.Characteristics.CageCharacteristics;
import com.Model.Characteristics.Characteristics;

public class SafetyCage {

    public Characteristics characteristics;

    public SafetyCage() {

        this.characteristics = new CageCharacteristics();
    }

    public SafetyCage(HashMap<String, String> characteristics) {

        this.characteristics = new CageCharacteristics(characteristics);
    }

    public void getInformation() {
        //show info about cage
    }

}
