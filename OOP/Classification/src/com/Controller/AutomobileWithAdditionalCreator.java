package com.Controller;

import com.Model.Automobiles.Automobile;

import java.util.HashMap;

public interface AutomobileWithAdditionalCreator extends AutomobileCreator {

    Automobile createAutomobile(String automobileName,
                                HashMap<String, String> characteristics,
                                HashMap<String, String> additionalCharacteristics) throws Exception;
}
