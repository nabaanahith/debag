package com.enjaz.debug.logging.entities;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class PlatformConverter {
    //convert Platform Type failed to type suitable to store in db

    @TypeConverter
    public static PlatformType toStringPlatform(String  platrorm){
        return platrorm == null ? null:PlatformType.valueOf(platrorm);
    }

    @TypeConverter
    public static String  fromplat(PlatformType platformType){

        return platformType == null ? null :platformType.toString();
    }
}


