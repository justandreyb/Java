package com.Model.Automobiles.Passenger.Cars.Sport;

import com.Model.Automobiles.Passenger.Cars.Car;

import java.util.UUID;

public class Sport extends Car {

    private String hasSafetyCage;

    public Sport() throws Exception {

        try {

            initialize();

            setHasGPS("-");
            addCharacteristic(isHasGPS());

            setWheelsSize(0);
            addCharacteristic(getWheelsSize());

            setHasSafetyCage("-");
            addCharacteristic(isHasSafetyCage());
            UUID.randomUUID().toString();
        }
        catch(Exception exception){
            if (!exception.getMessage().contains("java.lang.NullPointer"))
                System.out.println("Error : " + exception);
        }
    }

    public void setHasSafetyCage(String hasSafetyCage) {
        this.hasSafetyCage = hasSafetyCage;
    }
    public String isHasSafetyCage() {
        return this.hasSafetyCage;
    }

}
