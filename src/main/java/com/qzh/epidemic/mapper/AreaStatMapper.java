package com.qzh.epidemic.mapper;

import com.qzh.epidemic.entity.AreaStat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaStatMapper {
    /**
     * @param areaStat areaStat
     * @return 成功插入的个数
     * @Description: 插入单独一条areaStat
     */
    int addAreaStat(@Param("areaStat") AreaStat areaStat);

    /**
     * @param areaStats areaStatList
     * @return 成功插入的个数
     * @Description: 批量插入areaStat数据，如果主键相等则覆盖
     */
    int addAreaStatList(@Param("areaStats") List<AreaStat> areaStats);


    /**
     * @return List<AreaStat>
     * @Description: 查找所有省份信息
     */
    List<AreaStat> selectAll();

    /**
     * @param locationId 省份id
     * @return 省份名称
     * @Description: 获取省份名称
     */
    String getProvinceNameById(@Param("locationId") int locationId);

    /**
     * @param locationId 省份id
     * @return AreaStat
     * @Description: 通过id获取AreaStat
     */
    AreaStat getAreaStatById(@Param("locationId") int locationId);

    /**
     * @return List<AreaStat>
     * @Description: 获取省份名称以及id的实体表
     */
    List<AreaStat> getProvinceNameAndIdList();
}
