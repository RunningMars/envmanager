package com.bikego.env.management.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class IdUtils {
    public static int getYear() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("y");
        String strYear = sdf.format(date);
        String strNum = strYear.substring(strYear.length() - 2, strYear.length());
        return Integer.valueOf(strNum).intValue();
    }

    public static int getSecondsOfToday() {
        Date currentDate = new Date();
        LocalDateTime today = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault()).plusDays(0).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);

        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault());
        long seconds = ChronoUnit.SECONDS.between(today, currentDateTime);
        return (int) seconds;
    }

    public static int getMinuteSeconds() {
        Date date = new Date();
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.MILLISECOND);
    }

    public static int getDayOfYear() {
        Date date = new Date();
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.DAY_OF_YEAR);
    }

    public static int getRandom3Int() {
        return (int)(1000+Math.random()*(999-100+1));
    }

    public static int getRandom5Int() {
        return (int)(10000+Math.random()*(99999-10000+1));
    }

    public static int getRandom6Int() {
        return (int)(100000+Math.random()*(999999-100000+1));
    }

    public static String getNo(int code) {
        String dayString = String.format("%03d", getDayOfYear());
        String secondString = String.format("%05d", getSecondsOfToday());
        String minuteSecondString = String.format("%03d", getMinuteSeconds());

        return "" + code + getYear() + dayString + secondString + minuteSecondString + getRandom3Int();
    }

    public static long getId(int code) {
        return Long.valueOf(getNo(code)).longValue();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        String no = getNo(11);
        Long.valueOf(no);
        System.out.println(no);
        System.out.println(getId(11));
    }
}
