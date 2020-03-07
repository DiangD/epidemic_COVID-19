package com.qzh.epidemic.crawler;

import com.qzh.epidemic.utils.StatisticUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName CrawlerTool
 * @Author DiangD
 * @Date 2020/2/24
 * @Version 1.0
 * @Description 爬虫工具类
 **/
public class CrawlerTool {
    private static Document page;

    /**
     * 正则匹配获取
     * @param regex 正则表达式
     * @param attributeKey  html中的唯一标识
     * @param attributeValue id的具体参数
     * @return json形式的字符串
     */
    public static String getInformation(String regex , String attributeKey, String attributeValue){
        String result=null;
        //表达式对象
        Pattern p = Pattern.compile(regex);
        //创建Matcher对象
        Elements pageElements = page.getElementsByAttributeValue(attributeKey,attributeValue);
        Matcher m = p.matcher(pageElements.toString());
        if(m.find()) {  //该方法扫描输入的序列，查找与该模式匹配的一个子序列
            result=m.group();
        }
        return result;
    }

    /**
     * @return statistic data json 字符串
     */
    public static String getStatisticInformation() {
        Element elementById = page.getElementById(Crawler.STATIC_INFORMATION_ATTRIBUTE);
        //由于在借鉴的过程发现。json数据的内容及格式会发生改变正则匹配不起作用。所以使用切割字符串的方法。
        String strOrigin = elementById.toString();
        return StatisticUtil.toJsonString(strOrigin);
    }

    /**
     * 通过Jsoup获取整个html页面
     * @param url 爬取页面的url
     */
    public static void getPageByJSoup(String url) {
        try {
            page = Jsoup.connect(url).get();
        } catch (IOException e) {
           e.printStackTrace();
        }

    }
}
