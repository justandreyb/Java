package com.Model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Serialization implements Serializable {

    public abstract void serializeFile(Object object) throws Exception;
    public abstract ArrayList deserializeFile(String objectName) throws Exception;
}
