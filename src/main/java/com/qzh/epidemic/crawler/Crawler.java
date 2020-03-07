package com.qzh.epidemic.crawler;

/**
 * @ClassName Crawler
 * @Author DiangD
 * @Date 2020/2/24
 * @Version 1.0
 * @Description 爬虫常数
 **/
public class Crawler {
    public static final String URL = "https://3g.dxy.cn/newh5/view/pneumonia";

    /**
     * 时间线新闻
     */
    public static final String TIME_LINE_REGEX_TEMPLATE = "\\[(.*?)\\]";
    public static final String TIME_LINE_ATTRIBUTE = "getTimelineService";
    /**
     * 各省信息
     */
    public static final String AREA_INFORMATION_REGEX_TEMPLATE = "\\[(.*)\\]";
    public static final String AREA_INFORMATION_ATTRIBUTE = "getAreaStat";
    /**
     * 总数据
     */
    public static final String STATIC_INFORMATION_ATTRIBUTE = "getStatisticsService";

    /**
     * 各国数据
     */
    public static final String COUNTRY_INFO_REGEX_TEMPLATE = "\\[(.*?)\\]";
    public static final String COUNTRY_INFORMATION_ATTRIBUTE = "getListByCountryTypeService2";
}
