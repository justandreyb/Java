package com.Model;

import com.Controller.AutomobileCreator;

import java.util.HashMap;

public class Creator implements AutomobileCreator {

    HashMap<String, Class<Automobile>> automobiles = new HashMap<>();

    public Creator() throws Exception {
        try {

            this.automobiles.put("Sport", (Class<Automobile>) Class.forName("com.Model.Automobiles.Passenger.Cars.Sport.Sport"));
            this.automobiles.put("Standart", (Class<Automobile>) Class.forName("com.Model.Automobiles.Passenger.Cars.Standart.Standart"));
            this.automobiles.put("Specialized", (Class<Automobile>) Class.forName("com.Model.Automobiles.Trucks.Specialized.Specialized"));
            this.automobiles.put("Van", (Class<Automobile>) Class.forName("com.Model.Automobiles.Trucks.Vans.Van"));
            this.automobiles.put("City", (Class<Automobile>) Class.forName("com.Model.Automobiles.Passenger.Buses.City.City"));
            this.automobiles.put("Intercity", (Class<Automobile>) Class.forName("com.Model.Automobiles.Passenger.Buses.Intercity.Intercity"));

        }
        catch (Exception ex) {
            new Exception(ex);
        }
    }

    @Override
    public Automobile getAutomobile(String automobileType) throws Exception {
        try {
            return this.automobiles.get(automobileType).newInstance();
        }
        catch (Exception ex) {
            return null;
        }
    }

}
