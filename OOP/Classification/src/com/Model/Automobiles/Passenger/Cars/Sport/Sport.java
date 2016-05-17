package com.Model.Automobiles.Passenger.Cars.Sport;

import com.Model.Additions.SafetyCage;
import com.Model.Additions.Wheels;
import com.Model.Automobiles.Passenger.Cars.Car;

import java.util.HashMap;

public class Sport extends Car {

    public Sport() throws Exception {

        try {
            SafetyCage safetyCage = new SafetyCage();
            characteristics.addCharacteristics(safetyCage.characteristics.getCharacteristics());

        }
        catch(Exception exception){
            System.out.println("Error : " + exception);
        }
    }

    public Sport(HashMap<String, String> characteristics) throws Exception {

        try {
            this.characteristics.setCharacteristics(characteristics);
            SafetyCage safetyCage = new SafetyCage();
            this.characteristics.addCharacteristics(safetyCage.characteristics.getCharacteristics());

        }
        catch(Exception exception){
            System.out.println("Error : " + exception);
        }
    }

    public Sport(HashMap<String, String> characteristics, HashMap<String, String> cageCharacteristics) throws Exception {

        try {
            this.characteristics.setCharacteristics(characteristics);
            SafetyCage safetyCage = new SafetyCage(cageCharacteristics);
            wheel = new Wheels();

            this.characteristics.addCharacteristics(safetyCage.characteristics.getCharacteristics());
            this.characteristics.addCharacteristics(wheel.characteristics.getCharacteristics());

        }
        catch(Exception exception){
            System.out.println("Error : " + exception);
        }
    }

    public Sport(HashMap<String, String> characteristics, HashMap<String, String> cageCharacteristics,
                 HashMap<String, String> wheelsCharacteristics) throws Exception {

        try {
            this.characteristics.setCharacteristics(characteristics);
            SafetyCage safetyCage = new SafetyCage(cageCharacteristics);
            wheel = new Wheels(wheelsCharacteristics);

            this.characteristics.addCharacteristics(safetyCage.characteristics.getCharacteristics());
            this.characteristics.addCharacteristics(wheel.characteristics.getCharacteristics());

        }
        catch(Exception exception){
            System.out.println("Error : " + exception);
        }
    }

    @Override
    public void getInformation() {
        //Get info about car
    }

}
