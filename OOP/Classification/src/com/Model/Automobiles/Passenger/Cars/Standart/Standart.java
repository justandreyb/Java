package com.Model.Automobiles.Passenger.Cars.Standart;

import com.Model.Additions.Mediaplayer;
import com.Model.Additions.SafetyCage;
import com.Model.Additions.Wheels;
import com.Model.Automobiles.Passenger.Cars.Car;

import java.util.HashMap;

public class Standart extends Car {


    public Standart() throws Exception {

        try {
            Wheels wheels = new Wheels();
            characteristics.addCharacteristics(wheels.characteristics.getCharacteristics());

        }
        catch(Exception exception){
            System.out.println("Error : " + exception);
        }
    }

    public Standart(HashMap<String, String> characteristics) throws Exception {

        try {

            this.characteristics.setCharacteristics(characteristics);

            Wheels wheels = new Wheels();
            this.characteristics.addCharacteristics(wheels.characteristics.getCharacteristics());

        }
        catch(Exception exception){
            System.out.println("Error : " + exception);
        }
    }

    public Standart(HashMap<String, String> characteristics,
                    HashMap<String, String> wheelsCharacteristics) throws Exception {

        try {
            this.characteristics.setCharacteristics(characteristics);

            this.wheel = new Wheels(wheelsCharacteristics);
            this.characteristics.addCharacteristics(this.wheel.characteristics.getCharacteristics());

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
