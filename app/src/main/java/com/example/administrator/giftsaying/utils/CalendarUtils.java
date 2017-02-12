package com.example.administrator.giftsaying.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *获取星期的工具
 * Created by Administrator on 2017/2/11.
 */

public class CalendarUtils {
    public static String getWeek(String time) {
        String week = "周";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(format.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
            week+="日";
        }
        else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY){
            week+="一";
        }else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.TUESDAY){
            week+="二";
        }else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY){
            week+="三";
        }else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.THURSDAY){
            week+="四";
        }else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY){
            week+="五";
        }else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
            week+="六";
        }
        return week;
    }
}
