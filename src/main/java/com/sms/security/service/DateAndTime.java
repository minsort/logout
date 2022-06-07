package com.sms.security.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTime {

    public static String getTime(){
        Date date = new Date();//создаем объект даты и времени
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");//устанавливаем формат для получения времени
        String timeVisit = time.format(date);//вносим в переменную время визита
        return timeVisit;
    }

    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat dates = new SimpleDateFormat("dd-MM-yyyy");//устанавливаем формат для получения даты
        String dateVisit = dates.format(date);//вносим в переменную дату визита
        return dateVisit;
    }
}
