package com.qzh.epidemic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qzh.epidemic.entity.Timeline;
import com.qzh.epidemic.mapper.TimeLineMapper;
import com.qzh.epidemic.service.TimeLineService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TimeLineServiceImpl
 * @Author DiangD
 * @Date 2020/2/24
 * @Version 1.0
 * @Description
 **/
@Service
@CacheConfig(cacheNames = {"cache-timeline"})
public class TimeLineServiceImpl implements TimeLineService {
    @Resource
    private TimeLineMapper timeLineMapper;

    /**
     * @return 所有TimeLine
     */
    @Override
    public PageInfo<Timeline> getTimelines(int pageSize,int pageNum) {
        PageInfo<Timeline> pageInfo;
        PageHelper.startPage(pageNum, pageSize);
        List<Timeline> timelines = timeLineMapper.selectAll();
        pageInfo = new PageInfo<>(timelines);
        return pageInfo;
    }

    /**
     * @param timelines timeLineList
     * 保存实体
     */
    @Override
    @CacheEvict(allEntries = true,beforeInvocation = true)
    public int addTimeLines(List<Timeline> timelines) {
        return timeLineMapper.addTimeLines(timelines);
    }

    /**
     * @return 获取最近更新的5条数据
     */
    @Override
    @Cacheable
    public List<Timeline> selectLatest5() {
        return timeLineMapper.selectLatest5();
    }
}
