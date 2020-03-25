package com.qzh.epidemic.entity;

import com.qzh.epidemic.utils.DateUtil;
import lombok.Data;

import java.security.PrivateKey;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TimeLine
 * @Author DiangD
 * @Date 2020/2/24
 * @Version 1.0
 * @Description 实时信息
 **/
@Data
public class Timeline {
    /**
     * id : 15004
     * pubDate : 1585130146000
     * pubDateStr : 11分钟前
     * title :  3月25日重庆市新冠肺炎疫情防控工作新闻发布会疫情通报
     * summary :    无新增境外输入新冠肺炎确诊病例市卫生健康委通报，3月24日0—24时，重庆市本地无新增新冠肺炎确诊病例，无新增境外输入新冠肺炎确诊病例。
     * infoSource : 重庆卫健委
     * sourceUrl : http://wsjkw.cq.gov.cn/yqxxyqtb/20200325/261172.html
     * provinceId :
     * infoType : 2
     * dataInfoState : 0
     * dataInfoOperator :
     * dataInfoTime : 1585130146000
     */

    private Integer id;
    private Long pubDate;
    private String pubDateStr;
    private String title;
    private String summary;
    private String infoSource;
    private String sourceUrl;
    private String provinceId;
    private Integer infoType;
    private Integer dataInfoState;
    private String dataInfoOperator;
    private Long dataInfoTime;
    private String publishDate;

    public void setDataInfoTime(Long dataInfoTime) {
        this.dataInfoTime = dataInfoTime;
        this.publishDate = DateUtil.transformToPublishDate(dataInfoTime);
    }
}
