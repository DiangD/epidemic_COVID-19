package com.qzh.epidemic.service.impl;

import com.qzh.epidemic.entity.StatisticData;
import com.qzh.epidemic.mapper.StatisticDataMapper;
import com.qzh.epidemic.service.StatisticDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName StatisticDataServiceImpl
 * @Author DiangD
 * @Date 2020/2/26
 * @Version 1.0
 * @Description
 **/
@Service
public class StatisticDataServiceImpl implements StatisticDataService {
    @Resource
    private StatisticDataMapper statisticDataMapper;

    /**
     * @param statisticData statisticData
     */
    @Override
    public void addStatisticData(StatisticData statisticData) {
        statisticDataMapper.addStatisticData(statisticData);
    }

    /**
     * @param statisticDataList statisticDataList
     */
    @Override
    public void addStatisticDataList(List<StatisticData> statisticDataList) {
        statisticDataMapper.addStatisticDataList(statisticDataList);
    }

    /**
     * @return 数据表是否为空
     */
    @Override
    public boolean isEmpty() {
        int rowsCount = statisticDataMapper.getRowsCount();
        return rowsCount <= 0;
    }

    /**
     * @return 获得最后一次更新表的时间
     */
    @Override
    public int getLatestDateId(int provinceId) {
        return statisticDataMapper.getLatestDateId(provinceId);
    }

    /**
     * @param provinceId 省份id
     * @return 获取某个省最近更新的现存确诊人数
     */
    @Override
    public Integer getLatestCurrentConfirmCountByProvinceId(Integer provinceId) {
        return statisticDataMapper.getLatestCurrentConfirmCountByProvinceId(provinceId);
    }

    /**
     * @param provinceId 省份id
     * @return 获取某个省份的历史记录
     */
    @Override
    public List<StatisticData> getStatisticDataListByProvinceId(Integer provinceId) {
        return statisticDataMapper.selectByProvinceId(provinceId);
    }
}
