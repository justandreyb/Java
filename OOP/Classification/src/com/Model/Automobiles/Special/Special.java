package com.Model.Automobiles.Special;

import com.Model.Automobile;

public class Special extends Automobile {

    private String serviceName;

    public Special() {

        initialize();

        setServiceName("-");
        this.addCharacteristic(getServiceName());
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public String getServiceName() {
        return this.serviceName;
    }

}
