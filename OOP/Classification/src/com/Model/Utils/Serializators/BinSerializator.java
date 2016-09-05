package com.Model.Utils.Serializators;

import com.Model.Automobile;
import com.Model.Serialization;
import com.Model.Utils.NameGetter;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class BinSerializator extends Serialization {

    @Override
    public void serializeFile(Object object) throws Exception {

            try {

                ObservableList observableList = (ObservableList) object;
                int listSize = observableList.size();
                ArrayList<Automobile> arrayList = new ArrayList<Automobile>(observableList);
/*

                for (int index = 0; index < listSize; index++) {
                    arrayList.add((Automobile) observableList.get(index));
                }
*/


                FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") +
                        "\\SavedObjects\\" + System.currentTimeMillis() + ".bin");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(arrayList);
                objectOutputStream.flush();
                objectOutputStream.close();

                //create arraylist, then try

            }
            catch (Exception exception) {
                System.out.println("Error : " + exception);
            }
        }

    @Override
    public ArrayList deserializeFile(String objectName) throws Exception {

        try {
            FileInputStream fileInputStream = new FileInputStream(objectName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ArrayList<Automobile> arrayList;
            try {
                arrayList = (ArrayList<Automobile>) objectInputStream.readObject();
                return arrayList;
            }
            catch (Exception exOpen) {
                System.out.println("This object is not pass");
                return null;
            }
        }
        catch (Exception exception) {
            System.out.println("Error : " + exception);
            return null;
    }
}
}
