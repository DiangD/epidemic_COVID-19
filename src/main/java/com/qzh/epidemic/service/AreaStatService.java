package com.qzh.epidemic.service;

import com.qzh.epidemic.entity.AreaStat;

import java.util.List;

public interface AreaStatService {

    void addAreaStatList(List<AreaStat> areaStats);

    List<AreaStat> selectAll();

    String getProvinceNameById(int locationId);

    AreaStat getAreaStatById(int locationId);

    List<AreaStat> getProvinceNameAndIdList();
}
