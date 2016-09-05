package com.Model.Automobiles.Passenger.Buses;

import com.Model.Automobiles.Passenger.Passenger;

public class Bus extends Passenger{

    private int countOfSeats;

    public void setCountOfSeats(int countOfSeats) {
        this.countOfSeats = countOfSeats;
    }
    public int getCountOfSeats() {
        return this.countOfSeats;
    }

}
