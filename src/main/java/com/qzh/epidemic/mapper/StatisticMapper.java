package com.qzh.epidemic.mapper;

import com.qzh.epidemic.entity.Statistic;
import org.apache.ibatis.annotations.Param;

public interface StatisticMapper {
    /**
     * @param statistic  statistic
     * @return 成功插入的个数
     */
    int addStatistic(@Param("statistic") Statistic statistic);

    /**
     * @return 获取最新的统计数据
     */
    Statistic selectStatistic();
}
