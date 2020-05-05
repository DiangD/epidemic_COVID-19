package com.qzh.epidemic.service.impl;

import com.qzh.epidemic.entity.CountryStat;
import com.qzh.epidemic.mapper.CountryStatMapper;
import com.qzh.epidemic.service.CountryStatService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = {"cache-countryStat"})
public class CountryStatServiceImpl implements CountryStatService {
    @Resource
    private CountryStatMapper countryStatMapper;

    /**
     * @param countryStats countryStatList
     * @Description: 批量添加数据
     */
    @Override
    @CacheEvict(allEntries = true,beforeInvocation = true)
    public void addCountryStatList(List<CountryStat> countryStats) {
        countryStatMapper.insertCountryStatList(countryStats);
    }

    /**
     * @param continents 国家所在的洲
     * @return 通过洲获得国家列表
     */
    @Override
    @Cacheable(key = "#a0")
    public List<CountryStat> getCountryStatsByContinents(String continents) {
        return countryStatMapper.selectByContinents(continents);
    }
}
