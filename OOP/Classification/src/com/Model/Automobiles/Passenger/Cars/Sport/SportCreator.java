package com.Model.Automobiles.Passenger.Cars.Sport;

import com.Controller.AutomobileWithAdditionalCreator;
import com.Model.Automobiles.Automobile;

import java.util.HashMap;

public class SportCreator implements AutomobileWithAdditionalCreator {

    @Override
    public Automobile createAutomobile(String automobileName) throws Exception {

        return new Sport();
    }

    @Override
    public Automobile createAutomobile(String automobileName,
                                       HashMap<String, String> characteristics) throws Exception {

        return new Sport(characteristics);
    }

    @Override
    public Automobile createAutomobile(String automobileName,
                                       HashMap<String, String> characteristics,
                                       HashMap<String, String> additionalCharacteristics) throws Exception {
        return new Sport(characteristics, additionalCharacteristics);
    }

    public Automobile createAutomobile(String automobileName,
                                       HashMap<String, String> characteristics,
                                       HashMap<String, String> additionalCharacteristics,
                                       HashMap<String, String> wheelsCharacteristics ) throws Exception {

        return new Sport(characteristics, additionalCharacteristics, wheelsCharacteristics);
    }

}
