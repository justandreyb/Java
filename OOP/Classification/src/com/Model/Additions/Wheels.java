package com.Model.Additions;

import com.Model.Additions.Characteristics.WheelsCharacteristics;
import com.Model.Characteristics.Characteristics;

import java.util.HashMap;

public class Wheels extends Additions {

    public Characteristics characteristics;

    public Wheels() {

        this.characteristics = new WheelsCharacteristics();
    }

    public Wheels(HashMap<String, String> characteristics) {

        this.characteristics = new WheelsCharacteristics(characteristics);
    }

}
