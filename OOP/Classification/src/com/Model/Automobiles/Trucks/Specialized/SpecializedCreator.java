package com.Model.Automobiles.Trucks.Specialized;

import com.Controller.AutomobileCreator;
import com.Model.Automobiles.Automobile;

import java.util.HashMap;

public class SpecializedCreator implements AutomobileCreator {

    @Override
    public Automobile createAutomobile(String automobileName) {
        return null;
    }

    @Override
    public Automobile createAutomobile(String automobileName, HashMap<String, String> characteristics) throws Exception {
        return null;
    }
}
