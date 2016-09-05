package com.Model.Automobiles.Passenger.Cars;

import com.Model.Automobiles.Passenger.Passenger;

public class Car extends Passenger{

    private int wheelsSize;

    public void setWheelsSize(int wheelsSize) {
        this.wheelsSize = wheelsSize;
    }

    public int getWheelsSize() {
        return this.wheelsSize;
    }

}
