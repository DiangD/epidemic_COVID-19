package com.qzh.epidemic.entity;

import com.qzh.epidemic.utils.DateUtil;
import lombok.Data;

/**
 * @ClassName Statistic
 * @Author DiangD
 * @Date 2020/2/25
 * @Version 1.0
 * @Description 全国数据统计
 **/

@Data
public class Statistic {
    private Integer id;
    private Long createTime;
    private Long modifyTime;
    private Integer confirmedCount;
    private Integer suspectedCount;
    private Integer curedCount;
    private Integer deadCount;
    private Integer seriousCount;
    private Integer suspectedIncr;
    private Integer confirmedIncr;
    private Integer curedIncr;
    private Integer deadIncr;
    private Integer seriousIncr;
    private Integer currentConfirmedCount;
    private Integer currentConfirmedIncr;
    private String publishDate;
    private GlobalStatistics globalStatistics;

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
        this.publishDate = DateUtil.transformToPublishDate(modifyTime);
    }
}
