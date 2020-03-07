package com.qzh.epidemic.service.impl;

import com.qzh.epidemic.entity.CountryStat;
import com.qzh.epidemic.mapper.CountryStatMapper;
import com.qzh.epidemic.service.CountryStatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CountryStatServiceImpl
 * @Author DiangD
 * @Date 2020/3/7
 * @Version 1.0
 * @Description
 **/
@Service
public class CountryStatServiceImpl implements CountryStatService {
    @Resource
    private CountryStatMapper countryStatMapper;

    /**
     * @param countryStats countryStatList
     * @Description: 批量添加数据
     */
    @Override
    public void addCountryStatList(List<CountryStat> countryStats) {
        countryStatMapper.insertCountryStatList(countryStats);
    }

    /**
     * @param continents 国家所在的洲
     * @return 通过洲获得国家列表
     */
    @Override
    public List<CountryStat> getCountryStatsByContinents(String continents) {
        return countryStatMapper.selectByContinents(continents);
    }
}
