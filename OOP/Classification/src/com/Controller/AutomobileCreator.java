package com.Controller;

import com.Model.Automobiles.Automobile;

import java.util.HashMap;

public interface AutomobileCreator{

    Automobile createAutomobile(String automobileName) throws Exception;
    Automobile createAutomobile(String automobileName, HashMap<String, String> characteristics) throws Exception;

}
