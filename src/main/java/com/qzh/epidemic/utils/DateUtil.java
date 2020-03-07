package com.qzh.epidemic.utils;

import org.quartz.SimpleScheduleBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Author DiangD
 * @Date 2020/3/2
 * @Version 1.0
 * @Description 时间转换工具类
 **/
public class DateUtil {

    /**
     * @param modifyTime 修改时间
     * @return 将系统毫秒值转化为格式化的时间
     */
    public static String transformToPublishDate(Long modifyTime) {
        Date date = new Date(modifyTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        String afterFormat = format.format(date);
        return afterFormat;
    }

    /**
     * @param dateId 日期
     * @return 将dateId转化为格式化的时间
     */
    public static String transformByDateId(Integer dateId) {
        String dateIdStr = String.valueOf(dateId);
        String substring = dateIdStr.substring(4);
        StringBuilder stringBuilder = new StringBuilder(substring);
        stringBuilder.insert(2, "-");
        return stringBuilder.toString();
    }
}
