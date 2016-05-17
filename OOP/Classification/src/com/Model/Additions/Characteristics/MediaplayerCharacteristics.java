package com.Model.Additions.Characteristics;

import com.Model.Characteristics.Characteristics;

import java.util.HashMap;

public class MediaplayerCharacteristics extends Characteristics {

    public MediaplayerCharacteristics() {

        HashMap<String, String> characteristics = new HashMap<>();
        characteristics.put("MediaplayerManufacturer", "-");
        characteristics.put("MediaplayerDate", "-");
        this.setCharacteristics(characteristics);
    }

    public MediaplayerCharacteristics(HashMap<String, String> characteristics) {

        this.setCharacteristics(characteristics);
    }

}