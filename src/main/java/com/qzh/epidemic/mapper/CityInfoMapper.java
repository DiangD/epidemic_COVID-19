package com.qzh.epidemic.mapper;

import com.qzh.epidemic.entity.CityInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityInfoMapper {

    /**
     * @param cityInfo cityInfo
     * @return 成功插入的个数
     */
    int addCityInfo(@Param("cityInfo") CityInfo cityInfo);

    /**
     * @Description: 批量插入cityInfo数据，如果主键相等则覆盖
     * @param cityInfos cityInfos
     * @return 成功插入的个数
     */
    int addCityInfoList(@Param("cityInfos") List<CityInfo> cityInfos);


    /**
     * @Description: 查找某个省份所有的城市信息
     * @param provinceId 省份的locationId
     * @return List<CityInfo>
     */
    List<CityInfo> selectByProvinceId(Integer provinceId);
}
