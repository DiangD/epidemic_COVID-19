package com.qzh.epidemic.service.impl;

import com.qzh.epidemic.entity.AreaStat;
import com.qzh.epidemic.entity.CityInfo;
import com.qzh.epidemic.mapper.AreaStatMapper;
import com.qzh.epidemic.service.AreaStatService;
import com.qzh.epidemic.service.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AreaStatServiceImpl
 * @Author DiangD
 * @Date 2020/2/26
 * @Version 1.0
 * @Description areaStat服务实现类
 **/
@Service
@CacheConfig(cacheNames = {"cache-areaStat"})
public class AreaStatServiceImpl implements AreaStatService {
    @Resource
    private AreaStatMapper areaStatMapper;
    @Autowired
    private CityInfoService cityInfoService;

    /**
     * @param areaStats areaStatList
     */
    @Override
    @CacheEvict(allEntries = true,beforeInvocation = true)
    public void addAreaStatList(List<AreaStat> areaStats) {
        areaStatMapper.addAreaStatList(areaStats);
    }

    /**
     * @return 获取AreaStat数据表
     */
    @Override
    @Cacheable(key = "#root.methodName")
    public List<AreaStat> selectAll() {
        return areaStatMapper.selectAll();
    }

    /**
     * @param locationId  id
     * @return 通过id获取省份名称
     */
    @Override
    public String getProvinceNameById(int locationId) {
        return areaStatMapper.getProvinceNameById(locationId);
    }

    /**
     * @param locationId  id
     * @return 通过id获取省份数据
     */
    @Override
    @Cacheable(key = "#a0")
    public AreaStat getAreaStatById(int locationId) {
        List<CityInfo> cityInfos = cityInfoService.getCityInfoByProvinceId(locationId);
        AreaStat areaStat = areaStatMapper.getAreaStatById(locationId);
        if (areaStat!=null) {
            areaStat.setCities(cityInfos);
            return areaStat;
        }
        return null;
    }

    /**
     * @return 获取所有省份的名称与id
     */
    @Override
    @Cacheable(key = "#root.methodName")
    public List<AreaStat> getProvinceNameAndIdList() {
        return areaStatMapper.getProvinceNameAndIdList();
    }
}
