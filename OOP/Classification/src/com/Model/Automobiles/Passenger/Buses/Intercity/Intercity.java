package com.Model.Automobiles.Passenger.Buses.Intercity;

import com.Model.Additions.Seats;
import com.Model.Automobiles.Passenger.Buses.Bus;

import java.util.HashMap;

public class Intercity extends Bus {

    public Intercity() {

        try {
            this.seats = new Seats();
            this.characteristics.addCharacteristics(this.seats.characteristics.getCharacteristics());

        }
        catch(Exception exception){
            System.out.println("Error : " + exception);
        }
    }

    public Intercity(HashMap<String, String> characteristics) {

        try {
            this.characteristics.setCharacteristics(characteristics);

            this.seats = new Seats();
            this.characteristics.addCharacteristics(this.seats.characteristics.getCharacteristics());

        }
        catch(Exception exception){
            System.out.println("Error : " + exception);
        }
    }

    public Intercity(HashMap<String, String> characteristics,
                HashMap<String, String> seatsCharacteristics) {

        try {
            this.characteristics.setCharacteristics(characteristics);

            this.seats = new Seats(seatsCharacteristics);
            this.characteristics.addCharacteristics(this.seats.characteristics.getCharacteristics());

        }
        catch(Exception exception){
            System.out.println("Error : " + exception);
        }

    }

}
