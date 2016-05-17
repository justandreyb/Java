package com.Model.Automobiles.Passenger.Buses.City;

import com.Controller.AutomobileCreator;
import com.Controller.AutomobileWithAdditionalCreator;
import com.Model.Automobiles.Automobile;

import java.util.HashMap;

public class CityCreator implements AutomobileWithAdditionalCreator {

    @Override
    public Automobile createAutomobile(String automobileName) {
        return new City();
    }

    @Override
    public Automobile createAutomobile(String automobileName,
                                       HashMap<String, String> characteristics) throws Exception {
        return new City(characteristics);
    }

    @Override
    public Automobile createAutomobile(String automobileName,
                                       HashMap<String, String> characteristics,
                                       HashMap<String, String> additionalCharacteristics) throws Exception {
        return new City(characteristics, additionalCharacteristics);
    }
}
