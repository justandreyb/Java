package com.Model.Utils;

import com.Model.Serialization;
import com.Model.Utils.Serializators.BinSerializator;
import com.Model.Utils.Serializators.FreeTextFormatSerializator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FactorySerializators {

    public HashMap<String, Class<? extends Serialization>> serializators;

    public FactorySerializators() throws ClassNotFoundException {

        serializators = new HashMap<>();
        serializators.put("TXT", FreeTextFormatSerializator.class);
        serializators.put("BIN", BinSerializator.class);
        serializators.put("XML", (Class<Serialization>) Class.forName("com.Model.Utils.Serializators.XMLSerializator"));

        Map<String,Supplier<Serialization>> suppliers = new HashMap<>();
        suppliers.put("",()->new FreeTextFormatSerializator());
        suppliers.get("").get();
    }

    public Serialization getSerializator(String serializatorName) throws IllegalAccessException, InstantiationException {

        return serializators.get(serializatorName).newInstance();
    }

}
