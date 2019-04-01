package com.enjaz.debug.logging.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Common {
    /**
     * format date class
     */

    /**
     * Hours and minuets
     */
    public static String getHoursAndMinuets(long l) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");

        return dateFormat.format(l);
    }

    /**
     * day and time inHours and minuets
     */
    public static String getDayAndTime(long l) {
        DateFormat dateFormat = new SimpleDateFormat("E HH:mm");

        return dateFormat.format(l);
    }

    /**
     * day and day in month
     */

    public static String getTimeAndDayAndMonth(long l) {
        DateFormat dateFormat = new SimpleDateFormat("dd E");

        return dateFormat.format(l);
    }

    /**
     *   day
     */

    public static String getDay(long l) {
        DateFormat dateFormat = new SimpleDateFormat(" E");

        return dateFormat.format(l);
    }
    /**
     *   day and month and year
     */

    public static String getDayMonthYear(long l) {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");

        return dateFormat.format(l);
    }

    /**
     * full date
     */
    public static String formatDate(long date) {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm");

        return dateFormat.format(date);
    }


}
