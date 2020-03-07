package com.qzh.epidemic.service;

import com.qzh.epidemic.entity.CityInfo;

import java.util.List;

public interface CityInfoService {

    int addCityInfo(CityInfo cityInfo);

    int addCityInfoList(List<CityInfo> cityInfos);

    List<CityInfo> getCityInfoByProvinceId(int provinceId);
}
