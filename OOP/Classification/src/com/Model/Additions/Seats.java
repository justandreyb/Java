package com.Model.Additions;

import java.util.HashMap;

import com.Model.Additions.Characteristics.SeatsCharacteristics;
import com.Model.Characteristics.Characteristics;

public class Seats extends Additions {

    public Characteristics characteristics;

    public Seats() {

        this.characteristics = new SeatsCharacteristics();
    }

    public Seats(HashMap<String, String> characteristics) {

        this.characteristics = new SeatsCharacteristics(characteristics);
    }

}
