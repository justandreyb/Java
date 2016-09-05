package com.Model.Automobiles.Passenger.Buses.Intercity;

import com.Model.Automobiles.Passenger.Buses.Bus;

public class Intercity extends Bus {

    private String hasCondition;

    public Intercity() {

        initialize();

        setHasGPS("-");
        addCharacteristic(isHasGPS());

        setCountOfSeats(0);
        addCharacteristic(getCountOfSeats());

        setHasCondition("-");
        addCharacteristic(isHasCondition());
    }

    public String isHasCondition() {
        return hasCondition;
    }
    public void setHasCondition(String hasCondition) {
        this.hasCondition = hasCondition;
    }
}
