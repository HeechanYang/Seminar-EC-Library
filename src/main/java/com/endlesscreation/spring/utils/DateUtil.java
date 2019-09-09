package com.endlesscreation.spring.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date dateAfter(Date date, int years, int month, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        cal.add(Calendar.DAY_OF_MONTH, month);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}
