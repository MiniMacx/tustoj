package com.tustcs.matrix.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by polykickshaw on 17-6-18.
 */
public class DateUtils {
    public static final SimpleDateFormat SDF=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static Date StringtoDate(String sDt) {
        try {
            return SDF.parse(sDt);
        } catch (ParseException e) {
            return null;
        }
    }
    public static String DatetoString(Date time){
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
        String ctime = formatter.format(time);
        System.out.println(ctime);
        return ctime;
    }
}
