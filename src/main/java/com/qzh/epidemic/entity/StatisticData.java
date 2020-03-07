package com.qzh.epidemic.entity;

import com.qzh.epidemic.utils.DateUtil;
import lombok.Data;

/**
 * @ClassName AreaStatHistory
 * @Author DiangD
 * @Date 2020/2/25
 * @Version 1.0
 * @Description 历史记录
 **/

//
// {
//         "confirmedCount": 22112,
//         "confirmedIncr": 2447,
//         "curedCount": 817,
//         "curedIncr": 184,
//         "currentConfirmedCount": 20677,
//         "currentConfirmedIncr": 2194,
//         "dateId": 20200206,
//         "deadCount": 618,
//         "deadIncr": 69
//         },

@Data
public class StatisticData {
    private Integer id;
    private Integer confirmedCount;
    private Integer confirmedIncr;
    private Integer curedCount;
    private Integer curedIncr;
    private Integer currentConfirmedCount;
    private Integer currentConfirmedIncr;
    private Integer dateId;
    private Integer deadCount;
    private Integer deadIncr;
    private Integer provinceId;
    private String publishDate;

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
        this.publishDate = DateUtil.transformByDateId(dateId);
    }
}
