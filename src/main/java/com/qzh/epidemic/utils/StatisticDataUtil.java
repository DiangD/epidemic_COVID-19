package com.qzh.epidemic.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qzh.epidemic.entity.StatisticData;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StatisticDataUtil
 * @Author DiangD
 * @Date 2020/2/26
 * @Version 1.0
 * @Description StatisticData工具包
 **/
@Slf4j
public class StatisticDataUtil {
    /**
     * @param url 网络文件的url
     * @return StatisticData实体
     */
    public static List<StatisticData> translateFromJsonFile(String url) {
        List<StatisticData> statisticDataList = new ArrayList<>();
        StringBuffer json = new StringBuffer();
        try {
            URL urlObj = new URL(url);
            URLConnection connection = urlObj.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            log.error("获取网络json文件[{}]失败！",url,e);
        }
        if (json.length() > 0) {
            JSONObject jsonObject = JSON.parseObject(String.valueOf(json));
            JSONArray jsonArray = JSON.parseArray(String.valueOf(jsonObject.get("data")));
            for (Object obj : jsonArray) {
                StatisticData statisticData = JSON.toJavaObject((JSON) obj, StatisticData.class);
                statisticDataList.add(statisticData);
            }
        }
        log.info("成功获取json文件[{}]",url);
        return statisticDataList;
    }
}
