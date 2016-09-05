package com.Model.Utils;

import java.util.Date;

public class NameGetter {

    public static String getName() {

        Date date = new Date();
        String currentDate = date.toString().replaceAll("[/-=*,.]", "");
        return currentDate;
    }

}
