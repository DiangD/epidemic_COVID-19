package com.qzh.epidemic.controller;

import com.qzh.epidemic.entity.CountryStat;
import com.qzh.epidemic.response.Response;
import com.qzh.epidemic.service.CountryStatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName CountryStatController
 * @Author DiangD
 * @Date 2020/3/7
 * @Version 1.0
 * @Description 各国数据控制器
 **/
@RestController
@Slf4j
public class CountryStatController {
    @Autowired
    private CountryStatService countryStatService;

    @RequestMapping("/country")
    public ModelAndView countryStat() {
        return new ModelAndView("country");
    }

    @GetMapping("/country/{continents}")
    public ResponseEntity<Response> getCountryStatByContinents(@PathVariable("continents")String continents) {
        try {
            List<CountryStat> countryStats = countryStatService.getCountryStatsByContinents(continents);
            return ResponseEntity.ok(new Response(true, "获取国家数据成功！", countryStats));
        } catch (Exception e) {
            log.error("获取国家数据失败",e);
            return ResponseEntity.ok(new Response(true, "获取国家数据失败！", e.getMessage()));
        }

    }
}
