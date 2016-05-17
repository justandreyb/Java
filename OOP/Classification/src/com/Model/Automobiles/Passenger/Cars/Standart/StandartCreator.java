package com.Model.Automobiles.Passenger.Cars.Standart;

import com.Controller.AutomobileWithAdditionalCreator;
import com.Model.Automobiles.Automobile;

import java.util.HashMap;

public class StandartCreator implements AutomobileWithAdditionalCreator {

    @Override
    public Automobile createAutomobile(String automobileName) throws Exception {

        return new Standart();
    }

    @Override
    public Automobile createAutomobile(String automobileName,
                                       HashMap<String, String> characteristics) throws Exception {

        return new Standart(characteristics);
    }

    @Override
    public Automobile createAutomobile(String automobileName,
                                       HashMap<String, String> characteristics,
                                       HashMap<String, String> additionalCharacteristics) throws Exception {

        return new Standart(characteristics, additionalCharacteristics);
    }

}
