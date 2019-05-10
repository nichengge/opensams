package com.opensams;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Kevin Leung
 */
public class DateUtils {

    private static final String COMMON_DATE_FORMAT = "yyyy/MM/dd";

    private static final String COMMON_TIME_FORMAT = "HH:mm:ss";

    private static final String COMMON_DATE_TIME_FORMAT = COMMON_DATE_FORMAT + " " + COMMON_TIME_FORMAT;

    public static String formatDate(Date date) {
        assert date != null;
        DateFormat dateFormat = new SimpleDateFormat(COMMON_DATE_FORMAT);
        return dateFormat.format(date);
    }

    public static String formatTime(Date date) {
        assert date != null;
        DateFormat dateFormat = new SimpleDateFormat(COMMON_TIME_FORMAT);
        return dateFormat.format(date);
    }

    public static String formatDateTime(Date date) {
        assert date != null;
        DateFormat dateFormat = new SimpleDateFormat(COMMON_DATE_TIME_FORMAT);
        return dateFormat.format(date);
    }

}
