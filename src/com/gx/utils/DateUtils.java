package com.gx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author zhangtan
 * @create 2018/6/4
 * @since 1.0.0
 */
public class DateUtils {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    public static  String getToday(){

        Date date = new Date();
        return  simpleDateFormat.format(date);
    }

}