package com.toranj.ghabz.utils;

import com.ibm.icu.text.SimpleDateFormat;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateConverter {

    //Gregorian to Jalali
    public static String convertGregorianToJalaliCalendar(Date date) {
        PersianDate pdate = new PersianDate(date);
        PersianDateFormat pdformater1 = new PersianDateFormat("yyyy/MM/dd");
        pdformater1.format(pdate);
        String year = String.valueOf(pdate.getShYear());
        String month = String.valueOf(pdate.getShMonth());
        String day = String.valueOf(pdate.getShDay());
        return year + "/" + month + "/" + day;
    }

    //Jalali to Gregorian
    public static Date convertJalaliToGregorianCalendar(Date date){
        String correctDate = getUpdateExpected(date);
        String[] dates = correctDate.split("/", 0);
        int day = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int year = Integer.parseInt(dates[2]);
        JalaliCalendarShamsiToMiladi jalaliCalendarShamsiToMiladi = new JalaliCalendarShamsiToMiladi(year, month, day + 1);
        GregorianCalendar gc = jalaliCalendarShamsiToMiladi.toGregorian();
        return gc.getTime();
    }

    //get Date and convert to pattern form
    public static String getUpdateExpected(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        return sdf.format(date);
    }

    //get jalaliYear from georgian Date
    public static String getYearJalaliYearFromGregorianDate(Date date) {
        PersianDate pdate = new PersianDate(date);
        PersianDateFormat pdformater1 = new PersianDateFormat("yyyy/MM/dd");
        pdformater1.format(pdate);
        String year = String.valueOf(pdate.getShYear());
        return year;
    }
}