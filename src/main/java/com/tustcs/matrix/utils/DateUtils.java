package com.tustcs.matrix.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by polykickshaw on 17-6-18.
 */
public class DateUtils {
   static SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static Date StringtoDate(String sDt) {
        try {

            return sdf.parse(sDt);
        } catch (ParseException e) {
            return null;
        }
    }
}
