package com.qzh.epidemic.entity;

import lombok.Data;

/**
 * @ClassName ForeignStatistics
 * @Author DiangD
 * @Date 2020/4/10
 * @Version 1.0
 * @Description 全球数据统计信息
 **/
@Data
public class GlobalStatistics {
    /**
     * currentConfirmedCount : 1121520
     * confirmedCount : 1561559
     * curedCount : 344976
     * deadCount : 95063
     * currentConfirmedIncr : 1207
     * confirmedIncr : 6636
     * curedIncr : 5188
     * deadIncr : 241
     */
    private Integer id;
    private Integer currentConfirmedCount;
    private Integer confirmedCount;
    private Integer curedCount;
    private Integer deadCount;
    private Integer currentConfirmedIncr;
    private Integer confirmedIncr;
    private Integer curedIncr;
    private Integer deadIncr;
}
