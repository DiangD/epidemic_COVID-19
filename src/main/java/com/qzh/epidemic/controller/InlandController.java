package com.qzh.epidemic.controller;

import com.qzh.epidemic.entity.AreaStat;
import com.qzh.epidemic.service.AreaStatService;
import com.qzh.epidemic.service.StatisticDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName InlandController
 * @Author DiangD
 * @Date 2020/3/2
 * @Version 1.0
 * @Description 国内疫情处理器
 **/
@RestController
public class InlandController {
    @Autowired
    private AreaStatService areaStatService;


    @RequestMapping("/inland")
    public ModelAndView inlandChina(Model model) {
        List<AreaStat> areaStats = areaStatService.selectAll();
        model.addAttribute("areaStats", areaStats);
        return new ModelAndView("inland", "inlandModel", model);
    }
}
