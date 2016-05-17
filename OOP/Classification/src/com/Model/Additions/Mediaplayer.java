package com.Model.Additions;

import com.Model.Additions.Characteristics.MediaplayerCharacteristics;
import com.Model.Characteristics.Characteristics;

import java.util.HashMap;

public class Mediaplayer extends Additions {

    public Characteristics characteristics;

    public Mediaplayer() {

        this.characteristics = new MediaplayerCharacteristics();
    }

    public Mediaplayer(HashMap<String, String> characteristics) {

        this.characteristics = new MediaplayerCharacteristics(characteristics);
    }

}
