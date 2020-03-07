package com.qzh.epidemic.service;

import com.github.pagehelper.PageInfo;
import com.qzh.epidemic.entity.Timeline;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName TimeLineService
 * @Author DiangD
 * @Date 2020/2/24
 * @Version 1.0
 * @Description
 **/
public interface TimeLineService {

    PageInfo<Timeline> getTimelines(int pageSize,int pageNum);

    int addTimeLines(@Param("timelines") List<Timeline> timelines);

    List<Timeline> selectLatest5();
}
