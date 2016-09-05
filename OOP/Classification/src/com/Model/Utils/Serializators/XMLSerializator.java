package com.Model.Utils.Serializators;

import com.Model.Serialization;
import com.Model.Utils.NameGetter;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class XMLSerializator extends Serialization {

    @Override
    public void serializeFile(Object object) {

        XMLEncoder encoder;
        try {

            FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") +
                    "\\SavedObjects\\" + System.currentTimeMillis() + ".xml");
            encoder = new XMLEncoder(new BufferedOutputStream(fileOutputStream));

            encoder.writeObject(object);

            encoder.close();

        } catch (FileNotFoundException fileNotFound) {
            System.out.println("ERROR: While Creating or Opening the File");
        }
    }

    @Override
    public ArrayList deserializeFile(String objectName) throws Exception {

        XMLDecoder decoder;
        try {

            FileInputStream fileInputStream = new FileInputStream(objectName);
            decoder = new XMLDecoder(new BufferedInputStream(fileInputStream));

            return (ArrayList) decoder.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
            return null;
        }
    }
}
