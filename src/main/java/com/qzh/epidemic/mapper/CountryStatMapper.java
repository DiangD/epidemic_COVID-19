package com.qzh.epidemic.mapper;

import com.qzh.epidemic.entity.CountryStat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountryStatMapper {
    /**
     * @param countryStats  countryStatList
     * @return 成功插入的个数
     * @Description: 批量插入国家信息
     */
    int insertCountryStatList(@Param("countryStats") List<CountryStat> countryStats);

    /**
     * @param continents 国家所在的洲
     * @return countryStatList
     * @Description: 通过国家所在的洲获取国家列表
     */
    List<CountryStat> selectByContinents(@Param("continents") String continents);
}
