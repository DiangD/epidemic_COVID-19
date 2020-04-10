package com.qzh.epidemic.mapper;

import com.qzh.epidemic.entity.GlobalStatistics;
import org.apache.ibatis.annotations.Param;

public interface GlobalStatisticsMapper {
    int insertGlobalStatistics(@Param("globalStatistics") GlobalStatistics globalStatistics);

    GlobalStatistics selectGlobalStatistics();
}
