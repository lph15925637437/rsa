package com.lph.rsa.Utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * dateTime类似转换为UTC类型的时间格式工具类
 *
 * @version V1.0
 * @author: lph
 * @date: 2019/7/31 8:48
 */
public class LocalAndIsoTimeTransferUtil {

    public static final Logger log = LoggerFactory.getLogger(LocalAndIsoTimeTransferUtil.class);

    /**
     *  本地时间转iso格式时间
     * @param date
     * @return
     */
    public static String localTimeToisoTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        TimeZone utcZone = TimeZone.getTimeZone("UTC");
        format.setTimeZone(utcZone);

        String format1 = format.format(date);

        return format1;
    }

    /**
     *  iso格式转本地格式
     * @param isoDate
     * @return
     */
    public static String isoTimeFromDateTime(String isoDate) {
        DateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        DateFormat localFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return localFormat.format(isoFormat.parse(isoDate));
        } catch (ParseException e) {
           log.error("date format error:{}", e.getMessage());
            return null;
        }
    }

    public static String localTime(Date date){
        DateFormat localFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = localFormat.format(date);

        return format;
    }

    public static void main(String[] args) {//
        String time = localTimeToisoTime(new Date());
        System.err.println(time);
        String localTime = isoTimeFromDateTime(time);
        System.err.println(localTime);

        String local = localTime(new Date());

        System.err.println("本地时间: " + local);



    }


}
