package com.qzh.epidemic.controller;

import com.alibaba.fastjson.JSON;
import com.qzh.epidemic.entity.AreaStat;
import com.qzh.epidemic.entity.Statistic;
import com.qzh.epidemic.entity.Timeline;
import com.qzh.epidemic.response.Response;
import com.qzh.epidemic.service.AreaStatService;
import com.qzh.epidemic.service.StatisticService;
import com.qzh.epidemic.service.TimeLineService;
import com.qzh.epidemic.vo.MapData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName IndexController
 * @Author DiangD
 * @Date 2020/3/2
 * @Version 1.0
 * @Description 首页的控制器
 **/
@RestController
@Slf4j
public class IndexController {
    @Autowired
    private StatisticService statisticService;
    @Autowired
    private TimeLineService timeLineService;
    @Autowired
    private AreaStatService areaStatService;
    @RequestMapping("/index")
    public ModelAndView index(Model model) {
        Statistic statistic = statisticService.selectStatistic();
        List<Timeline> timelines = timeLineService.selectLatest5();
        List<AreaStat> provinceNameAndIdList = areaStatService.getProvinceNameAndIdList();
        model.addAttribute("provinceNameAndIdList", provinceNameAndIdList);
        model.addAttribute("statistic", statistic);
        model.addAttribute("timelines", timelines);
        return new ModelAndView("index","indexModel",model);
    }

    @GetMapping("/getEpidemicChinaMap/{type}")
    public ResponseEntity<Response> getEpidemicChinaMap(@PathVariable("type") String type) {
        try {
            List<AreaStat> areaStats = areaStatService.selectAll();
            ArrayList<MapData> epidemicData = new ArrayList<>();
            for (AreaStat areaStat : areaStats) {
                if ("currentConfirmedCount".equals(type)) {
                    epidemicData.add(new MapData(areaStat.getProvinceShortName(),areaStat.getCurrentConfirmedCount()));
                } else if ("confirmedCount".equals(type)) {
                    epidemicData.add(new MapData(areaStat.getProvinceShortName(),areaStat.getConfirmedCount()));
                }
            }
            return ResponseEntity.ok(new Response(true, "全国数据获取成功！", epidemicData));
        } catch (Exception e) {
            log.error("全国数据获取失败",e);
            return ResponseEntity.ok(new Response(false, "全国数据获取失败！",e.getMessage()));
        }

    }
}
