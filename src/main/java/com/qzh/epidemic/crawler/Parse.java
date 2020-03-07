package com.qzh.epidemic.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qzh.epidemic.entity.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Parse
 * @Author DiangD
 * @Date 2020/2/24
 * @Version 1.0
 * @Description 将json解析成对应的实体
 **/
@Slf4j
public class Parse {

    /**
     * 解析地区信息JSON数据
     * @param areaInformation 地区信息
     * @return areaStats
     */
    public static List<AreaStat> parseAreaInformation(String areaInformation){
        List<AreaStat> areaStats = new ArrayList<>();
        JSONArray objects = JSON.parseArray(areaInformation);
        for(Object object : objects){
            AreaStat areaStat = JSON.toJavaObject((JSON) object, AreaStat.class);
            areaStats.add(areaStat);
        }
        return areaStats;
    }


    /**
     * 解析时间线信息JSON数据
     * @param timeLineInformation  时间线信息
     * @return timeLines
     */
    public static List<Timeline> parseTimeLineInformation(String timeLineInformation) {
        List<Timeline> timelines = new ArrayList<>();
        JSONArray objects = JSON.parseArray(timeLineInformation);
        for (Object object : objects) {
            Timeline timeLine = JSON.toJavaObject((JSON) object, Timeline.class);
            timelines.add(timeLine);
        }
        return timelines;
    }

    /**
     * 解析国内统计信息数据
     * @param statisticInformation 统计信息数据
     * @return statistic
     */
    public static Statistic parseStatisticInformation(String statisticInformation) {
        JSONObject parse =  JSON.parseObject(statisticInformation);
        Statistic statistic = JSON.toJavaObject(parse, Statistic.class);
        log.info(String.valueOf(statistic));
        return statistic;
    }

    /**
     * 解析国家信息数据
     * @param countryStatInformation 国家信息
     * @return countryStats
     */
    public static List<CountryStat> parseCountryStatInformation(String countryStatInformation) {
        List<CountryStat> countryStats = new ArrayList<>();
        JSONArray objects = JSON.parseArray(countryStatInformation);
        for (Object object : objects) {
            CountryStat countryStat = JSON.toJavaObject((JSON) object, CountryStat.class);
            countryStats.add(countryStat);
        }
        return countryStats;
    }
}
