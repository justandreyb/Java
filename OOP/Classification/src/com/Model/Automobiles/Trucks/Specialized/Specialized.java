package com.Model.Automobiles.Trucks.Specialized;

import com.Model.Automobiles.Trucks.Truck;

public class Specialized extends Truck {

    private int sizeGasolineTank;

    public Specialized () {

        initialize();

        setSizeGasolineTank(0);
        this.addCharacteristic(getSizeGasolineTank());
        setAxleCount(0);
        this.addCharacteristic(getAxleCount());
    }

    public void setSizeGasolineTank(int sizeGasolineTank) {
        this.sizeGasolineTank = sizeGasolineTank;
    }
    public int getSizeGasolineTank() {
        return this.sizeGasolineTank;
    }

}
