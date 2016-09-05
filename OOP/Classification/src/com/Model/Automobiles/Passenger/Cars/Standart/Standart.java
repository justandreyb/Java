package com.Model.Automobiles.Passenger.Cars.Standart;

import com.Model.Automobiles.Passenger.Cars.Car;

public class Standart extends Car {

    public Standart() {

        initialize();

        setHasGPS("-");
        addCharacteristic(isHasGPS());

        setWheelsSize(0);
        addCharacteristic(getWheelsSize());
    }

}
