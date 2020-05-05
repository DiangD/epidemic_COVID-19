package com.qzh.epidemic.service;

import com.qzh.epidemic.crawler.Crawler;
import com.qzh.epidemic.crawler.CrawlerTool;
import com.qzh.epidemic.crawler.Parse;
import com.qzh.epidemic.entity.*;
import com.qzh.epidemic.utils.StatisticDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @ClassName CrawlerInfoService
 * @Author DiangD
 * @Date 2020/2/24
 * @Version 1.0
 * @Description 爬虫获取数据并插入到数据库
 **/
@Service
@Slf4j
public class CrawlerService {

    @Autowired
    private TimeLineService timeLineService;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private AreaStatService areaStatService;

    @Autowired
    private StatisticDataService statisticDataService;

    @Autowired
    private CityInfoService cityInfoService;

    @Autowired
    private CountryStatService countryStatService;

    @Autowired
    private GlobalStatisticsService globalStatisticsService;

    /**
     * 插入或者更新全部表的数据
     */
    @Transactional
    public void saveOrUpdateAllInformation() {
        getStatisticByCrawler();
        getAreaStatInfoByCrawler();
        getTimeLineInfoByCrawler();
        getCountryStatsByCrawler();
        log.info("数据更新同步成功");
    }


    /**
     * 通过爬虫获取并解析json数据，完成area的数据插入与更新
     *
     */
    @Transactional
    public void getAreaStatInfoByCrawler() {
        //获取html
        CrawlerTool.getPageByJSoup(Crawler.URL);
        //提取area信息的json数据
        String areaInfos = CrawlerTool.getInformation(Crawler.AREA_INFORMATION_REGEX_TEMPLATE, "id", Crawler.AREA_INFORMATION_ATTRIBUTE);
        //解析
        List<AreaStat> areaStats = Parse.parseAreaInformation(areaInfos);
        List<StatisticData> statisticDataList;
        boolean isStatisticDataEmpty = statisticDataService.isEmpty();
        //插入更新areaStat
        areaStatService.addAreaStatList(areaStats);
        for (AreaStat areaStat : areaStats) {
            statisticDataList = StatisticDataUtil.translateFromJsonFile(areaStat.getStatisticsData());
            for (StatisticData statisticData : statisticDataList) {
                statisticData.setProvinceId(areaStat.getLocationId());
                if (!isStatisticDataEmpty) {
                    //判断是更新操作还是全部插入
                    if (statisticData.getDateId() > statisticDataService.getLatestDateId(statisticData.getProvinceId())) {
                        statisticDataService.addStatisticData(statisticData);
                    }
                }
            }
            //插入cityInfos
            for (CityInfo city : areaStat.getCities()) {
                city.setProvinceId(areaStat.getLocationId());
                cityInfoService.addCityInfo(city);
            }

            //插入statisticData
            if (isStatisticDataEmpty) {
                statisticDataService.addStatisticDataList(statisticDataList);
            }
        }
        log.info("地区数据同步成功");
    }


    /**
     * 通过爬虫获取并解析json数据，完成timeline的数据插入与更新
     *
     * @return List<TimeLine>
     */
    @Transactional
    public List<Timeline> getTimeLineInfoByCrawler() {
        //获取html
        CrawlerTool.getPageByJSoup(Crawler.URL);
        //提取timeline模块的json信息
        String timeLineInfos = CrawlerTool.getInformation(Crawler.TIME_LINE_REGEX_TEMPLATE, "id", Crawler.TIME_LINE_ATTRIBUTE);
        //解析
        List<Timeline> timelines = Parse.parseTimeLineInformation(timeLineInfos);
        //插入到数据库
        timeLineService.addTimeLines(timelines);
        log.info("实时信息同步成功");
        return timelines;
    }

    /**
     * 通过爬虫获取并解析json数据，完成statistic的数据插入与更新
     *
     * @return Statistic
     */
    @Transactional
    public Statistic getStatisticByCrawler() {
        //获取html
        CrawlerTool.getPageByJSoup(Crawler.URL);
        Statistic statistic;
        //提取statistic模块的json信息
        //解析
        String statisticInfo = CrawlerTool.getInformation(Crawler.STATIC_INFORMATION_TEMPLATE, "id", Crawler.STATIC_INFORMATION_ATTRIBUTE);
        statistic = Parse.parseStatisticInformation(statisticInfo);
        statistic.getGlobalStatistics().setId(statistic.getId());
        statisticService.addStatistic(statistic);
        globalStatisticsService.addGlobalStatistics(statistic.getGlobalStatistics());
        log.info("统计数据同步成功");
        return statistic;
    }

    /**
     * 通过爬虫获取并解析json数据，完成CountryStat的数据插入与更新
     * @return countryStats
     */
    public List<CountryStat> getCountryStatsByCrawler() {
        //获取html
        CrawlerTool.getPageByJSoup(Crawler.URL);
        //提取countryStat模块的json信息
        String countryStatInfos = CrawlerTool.getInformation(Crawler.COUNTRY_INFO_REGEX_TEMPLATE, "id", Crawler.COUNTRY_INFORMATION_ATTRIBUTE);
        //解析
        List<CountryStat> countryStats = Parse.parseCountryStatInformation(countryStatInfos);
        // 插入数据库
        countryStatService.addCountryStatList(countryStats);
        log.info("各个国家统计信息同步成功");
        return countryStats;
    }
}
