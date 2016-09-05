package com.Model.Automobiles.Passenger.Buses.City;

import com.Model.Automobiles.Passenger.Buses.Bus;

public class City extends Bus {

    public City() {

        initialize();

        setHasGPS("-");
        addCharacteristic(isHasGPS());

        setCountOfSeats(0);
        addCharacteristic(getCountOfSeats());

    }

}
