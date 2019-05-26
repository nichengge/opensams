package com.opensams.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Kevin Leung
 */
public class DateUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

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

    public static Date parseDate(String dateStr) {
        assert dateStr != null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(COMMON_DATE_FORMAT);
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error("Parsing date error!");

            return null;
        }
    }

}
