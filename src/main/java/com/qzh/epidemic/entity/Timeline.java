package com.qzh.epidemic.entity;

import com.qzh.epidemic.utils.DateUtil;
import lombok.Data;

/**
 * @ClassName TimeLine
 * @Author DiangD
 * @Date 2020/2/24
 * @Version 1.0
 * @Description 实时信息
 **/
@Data
public class Timeline {

//    {"id":6298,
//    "pubDate":1582525654000,
//    "pubDateStr":"2小时前",
//    "title":"菲律宾明日从钻石公主号撤侨",
//    "summary":"菲律宾卫生部称，菲政府将于25日从“钻石公主”号撤侨，并安排包机将侨民接回。“钻石公主”号上共有538名菲律宾公民，有意向回国的400人左右，具体撤离人数要根据25日的检测结果确定，撤回人员将进行14天隔离。截至24日，菲律宾累计确诊新冠肺炎59例，其中2人治愈出院。\n",
//    "infoSource":"央视新闻",
//    "sourceUrl":"http://m.weibo.cn/2656274875/4475499332344791",
//    "provinceId":"1",
//    "createTime":1582526054000,"modifyTime":1582526054000},

    private Integer id;
    private Long pubDate;
    private String pubDateStr;
    private String title;
    private String summary;
    private String infoSource;
    private String sourceUrl;
    private String provinceId;
    private String provinceName;
    private Long createTime;
    private Long modifyTime;
    private String publishDate;

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
        this.publishDate = DateUtil.transformToPublishDate(modifyTime);
    }
}
