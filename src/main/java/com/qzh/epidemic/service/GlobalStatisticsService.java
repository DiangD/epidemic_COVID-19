package com.qzh.epidemic.service;

import com.qzh.epidemic.entity.GlobalStatistics;

public interface GlobalStatisticsService {
    /**
     * @param globalStatistics 全球统计信息
     */
    void addGlobalStatistics(GlobalStatistics globalStatistics);

    GlobalStatistics select();
}
