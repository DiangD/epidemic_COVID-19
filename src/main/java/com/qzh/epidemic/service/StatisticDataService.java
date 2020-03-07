package com.qzh.epidemic.service;

import com.qzh.epidemic.entity.StatisticData;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StatisticDataService {
    void addStatisticData(StatisticData statisticData);

    void addStatisticDataList(List<StatisticData> statisticDataList);

    boolean isEmpty();

    int getLatestDateId(@Param("provinceId") int provinceId);


    Integer getLatestCurrentConfirmCountByProvinceId(@Param("provinceId") Integer provinceId);

    List<StatisticData> getStatisticDataListByProvinceId(Integer provinceId);
}
