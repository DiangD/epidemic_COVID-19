package com.qzh.epidemic.controller;

import com.qzh.epidemic.entity.AreaStat;
import com.qzh.epidemic.response.Response;
import com.qzh.epidemic.service.AreaStatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MainController
 * @Author DiangD
 * @Date 2020/3/2
 * @Version 1.0
 * @Description 页面跳转控制器
 **/
@Controller
@Slf4j
public class MainController {
    @Autowired
    private AreaStatService areaStatService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/index";
    }

    @GetMapping("/getProvinceNameAndIdList")
    public ResponseEntity<Response> getProvinceNameAndIdList() {
        Map<String,Integer> provinceMap = new LinkedHashMap<>();
        try {
            List<AreaStat> provinceNameAndIdList = areaStatService.getProvinceNameAndIdList();
            for (AreaStat areaStat : provinceNameAndIdList) {
                provinceMap.put(areaStat.getProvinceShortName(), areaStat.getLocationId());
            }
            return ResponseEntity.ok(new Response(true, "获取省份列表成功！",provinceMap));
        } catch (Exception e) {
            log.error("获取省份列表失败",e);
            return ResponseEntity.ok(new Response(false, "获取省份列表失败！"));
        }

    }

}
