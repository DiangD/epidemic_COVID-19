package com.qzh.epidemic.entity;

import com.qzh.epidemic.utils.DateUtil;
import lombok.Data;

/**
 * @ClassName CountryStat
 * @Author DiangD
 * @Date 2020/3/7
 * @Version 1.0
 * @Description 各个国家统计信息实体
 **/
@Data
public class CountryStat {

    /**
     * id : 837423
     * createTime : 1583506516000
     * modifyTime : 1583506516000
     * tags :
     * countryType : 2
     * continents : 亚洲
     * provinceId : 7
     * provinceName : 韩国
     * provinceShortName :
     * cityName :
     * currentConfirmedCount : 6510
     * confirmedCount : 6593
     * suspectedCount : 0
     * curedCount : 41
     * deadCount : 42
     * comment :
     * sort : 0
     * operator : zhangjing1
     * locationId : 951004
     * countryShortCode : KOR
     */

    private Long createTime;
    private Long modifyTime;
    private Integer countryType;
    private String continents;
    private String provinceName;
    private String provinceShortName;
    private Integer currentConfirmedCount;
    private Integer confirmedCount;
    private Integer suspectedCount;
    private Integer curedCount;
    private Integer deadCount;
    private Integer locationId;
    private String countryShortCode;
    private String publishDate;

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
        this.publishDate = DateUtil.transformToPublishDate(modifyTime);
    }
}
