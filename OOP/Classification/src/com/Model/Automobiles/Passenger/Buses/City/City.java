package com.Model.Automobiles.Passenger.Buses.City;

import com.Model.Additions.Mediaplayer;
import com.Model.Additions.SafetyCage;
import com.Model.Additions.Seats;
import com.Model.Additions.Wheels;
import com.Model.Automobiles.Passenger.Buses.Bus;

import java.util.HashMap;

public class City extends Bus {

    public City() {

        try {
            this.seats = new Seats();
            this.characteristics.addCharacteristics(this.seats.characteristics.getCharacteristics());

        }
        catch(Exception exception){
            System.out.println("Error : " + exception);
        }
    }

    public City(HashMap<String, String> characteristics) {

        try {
            this.characteristics.setCharacteristics(characteristics);

            this.seats = new Seats();
            this.characteristics.addCharacteristics(this.seats.characteristics.getCharacteristics());

        }
        catch(Exception exception){
            System.out.println("Error : " + exception);
        }
    }

    public City(HashMap<String, String> characteristics,
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
