package com.qzh.epidemic.mapper;

import com.qzh.epidemic.entity.StatisticData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatisticDataMapper {
    /**
     * @param statisticData statisticData
     * @return 成功插入的个数
     */
    int addStatisticData(@Param("statisticData") StatisticData statisticData);

    /**
     * @param statisticDataList statisticDataList
     * @return 成功插入的个数
     * @Description: 批量插入StatisticData数据，如果主键相等则覆盖
     */
    int addStatisticDataList(@Param("statisticDataList") List<StatisticData> statisticDataList);

    /**
     * @return 获得最近一次更新的DateId
     */
    int getLatestDateId(@Param("provinceId") int provinceId);

    /**
     * @return 获取表的行数
     */
    int getRowsCount();

    /**
     * @return 获取某个省份前一天的感染数
     */
    Integer getLatestCurrentConfirmCountByProvinceId(@Param("provinceId") Integer provinceId);

    /**
     * @param provinceId 省份id
     * @return 获取某个省份的历史信息
     */
    List<StatisticData> selectByProvinceId(@Param("provinceId") Integer provinceId);
}
