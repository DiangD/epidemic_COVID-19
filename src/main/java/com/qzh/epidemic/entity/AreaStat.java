package com.qzh.epidemic.entity;

import com.qzh.epidemic.service.AreaStatService;
import com.qzh.epidemic.service.StatisticDataService;
import com.qzh.epidemic.service.impl.StatisticDataServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName AreaStat
 * @Author DiangD
 * @Date 2020/2/24
 * @Version 1.0
 * @Description 省份信息
 **/
@Data
public class AreaStat {
//    {"provinceName":"湖北省",
//    "provinceShortName":"湖北",
//    "currentConfirmedCount":45054,
//    "confirmedCount":64287,
//    "suspectedCount":0,
//    "curedCount":16738,
//    "deadCount":2495,
//    "comment":"",
//    "locationId":420000,
//    "statisticsData":"https://file1.dxycdn.com/2020/0223/618/3398299751673487511-135.json",
//    "cities":[{"cityName":"武汉","currentConfirmedCount":35674,"confirmedCount":46607,"suspectedCount":0,"curedCount":8946,"deadCount":1987,"locationId":420100},{"cityName":"孝感","currentConfirmedCount":2180,"confirmedCount":3465,"suspectedCount":0,"curedCount":1177,"deadCount":108,"locationId":420900},{"cityName":"黄冈","currentConfirmedCount":1142,"confirmedCount":2904,"suspectedCount":0,"curedCount":1659,"deadCount":103,"locationId":421100},{"cityName":"鄂州","currentConfirmedCount":878,"confirmedCount":1383,"suspectedCount":0,"curedCount":465,"deadCount":40,"locationId":420700}

    private StatisticDataService statisticDataService = new StatisticDataServiceImpl();

    private String provinceName;
    private String provinceShortName;
    private Integer currentConfirmedCount;
    private Integer confirmedCount;
    private Integer suspectedCount;
    private Integer curedCount;
    private Integer deadCount;
    private Integer locationId;
    private String comment;
    private String statisticsData;
    private List<CityInfo> cities;
    private Timestamp modifyTime;
    private Integer currentConfirmedIncr;
}
