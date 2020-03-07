package com.qzh.epidemic.mapper;

import com.qzh.epidemic.entity.Timeline;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TimeLineMapper {
     /**
      * @Description: 批量插入StatisticData数据，如果主键相等则覆盖
      * @param timelines timeLineList
      * @return 成功插入的个数
      */
     int addTimeLines(@Param("timelines") List<Timeline> timelines);

     /**
      * @return 获取所有最新信息
      */
     List<Timeline> selectAll();


     /**
      * @return 获取最近更新的5条数据
      */
     List<Timeline> selectLatest5();


}
