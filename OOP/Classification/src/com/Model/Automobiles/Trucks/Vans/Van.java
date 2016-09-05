package com.Model.Automobiles.Trucks.Vans;

import com.Model.Automobiles.Trucks.Truck;

public class Van extends Truck {

    private int sizeTrunk;

    public Van () {

        initialize();
        setAxleCount(0);
        this.addCharacteristic(getAxleCount());
        setSizeTrunk(0);
        this.addCharacteristic(getSizeTrunk());
    }

    public void setSizeTrunk(int amountTrunk) {
        this.sizeTrunk = amountTrunk;
    }
    public int getSizeTrunk() {
        return this.sizeTrunk;
    }

}
