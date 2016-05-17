package com.Model.Automobiles.Passenger.Buses.Intercity;

import com.Controller.AutomobileCreator;
import com.Controller.AutomobileWithAdditionalCreator;
import com.Model.Automobiles.Automobile;

import java.util.HashMap;

public class IntercityCreator implements AutomobileWithAdditionalCreator {

    @Override
    public Automobile createAutomobile(String automobileName) throws Exception {
        return new Intercity();
    }

    @Override
    public Automobile createAutomobile(String automobileName,
                                       HashMap<String, String> characteristics) throws Exception {
        return new Intercity(characteristics);
    }

    @Override
    public Automobile createAutomobile(String automobileName,
                                       HashMap<String, String> characteristics,
                                       HashMap<String, String> additionalCharacteristics) throws Exception {
        return new Intercity(characteristics, additionalCharacteristics);
    }
}
