package com.bishe.demo.common.util.tool;

import java.util.Calendar;
import java.util.Date;

public class Time {

    public static String getDir(String separator) {
        Date currentTime = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return year + separator + month + separator + day + separator;
    }
    
}
