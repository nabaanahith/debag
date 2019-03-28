package com.enjaz.debug.logging.entities;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    //convert date failed to type suitable to store in db
    @TypeConverter
    public static Date toDate(Long dateLong) {
        return dateLong == null ? null : new Date(dateLong);
    }

    @TypeConverter
    public static Long fromDate(Date date) {

        return date == null ? null : (date.getTime() / 1000);
    }
}
