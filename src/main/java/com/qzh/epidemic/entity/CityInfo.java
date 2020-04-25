package com.qzh.epidemic.entity;

import lombok.Data;
import org.apache.ibatis.javassist.SerialVersionUID;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ClassName CityStatistics
 * @Author DiangD
 * @Date 2020/2/24
 * @Version 1.0
 * @Description 城市信息
 * {"cityName":"武汉","confirmedCount":495,"suspectedCount":0,"curedCount":31,"deadCount":23},{"cityName":"孝感","confirmedCount":22,"suspectedCount":0,"curedCount":0,"deadCount":0}
 **/
@Data
public class CityInfo {

    /**
     * cityName : 武汉
     * confirmedCount : 495
     * suspectedCount : 0
     * curedCount : 31
     * deadCount : 23
     */
    private Integer locationId;
    private String cityName;
    private Integer currentConfirmedCount;
    private Integer confirmedCount;
    private Integer suspectedCount;
    private Integer curedCount;
    private Integer deadCount;
    private Timestamp modifyTime;
    private Integer provinceId;

}
