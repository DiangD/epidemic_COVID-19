package com.qzh.epidemic.controller;

import com.github.pagehelper.PageInfo;
import com.qzh.epidemic.entity.Timeline;
import com.qzh.epidemic.response.Response;
import com.qzh.epidemic.service.TimeLineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName TimelineController
 * @Author DiangD
 * @Date 2020/3/2
 * @Version 1.0
 * @Description 时间线控制器
 **/
@RestController
@Slf4j
public class TimelineController {
    @Autowired
    private TimeLineService timeLineService;

    @RequestMapping("/timeline")
    public ModelAndView timeline() {
        return new ModelAndView("timeline");
    }

    @GetMapping("/getTimeline")
    @ResponseBody
    public ResponseEntity<Response> getTimeline(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum) {
        try {
            PageInfo<Timeline> pageInfo = timeLineService.getTimelines(pageSize,pageNum);
            return ResponseEntity.ok(new Response(true, "时间线数据获取成功", pageInfo));
        } catch (Exception e) {
            log.error("时间线数据获取失败",e);
            return ResponseEntity.ok(new Response(false, e.getMessage()));
        }
    }

}
