package com.qzh.epidemic.utils;

/**
 * @ClassName StatisticUtil
 * @Author DiangD
 * @Date 2020/2/28
 * @Version 1.0
 * @Description StatisticUtil 工具类
 **/
public class StatisticUtil {


    /**
     * @param strOrigin 爬取的数据
     * @return json数据
     */
    public static String toJsonString(String strOrigin) {
        strOrigin = strOrigin.replace("<script id=\"getStatisticsService\">try { window.getStatisticsService = ", "");
        strOrigin = strOrigin.replace("}catch(e){}</script>", "");
        return strOrigin;
    }
}
