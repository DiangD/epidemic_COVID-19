package com.qzh.epidemic.controller;

import com.qzh.epidemic.entity.AreaStat;
import com.qzh.epidemic.entity.CityInfo;
import com.qzh.epidemic.entity.StatisticData;
import com.qzh.epidemic.response.Response;
import com.qzh.epidemic.service.AreaStatService;
import com.qzh.epidemic.service.CityInfoService;
import com.qzh.epidemic.service.StatisticDataService;
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
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @ClassName ProvinceController
 * @Author DiangD
 * @Date 2020/3/3
 * @Version 1.0
 * @Description 省份信息控制器
 **/
@RestController
@Slf4j
public class ProvinceController {
    @Autowired
    private AreaStatService areaStatService;
    @Autowired
    private CityInfoService cityInfoService;
    @Autowired
    private StatisticDataService statisticDataService;

    @RequestMapping("/province/{provinceId}")
    public ModelAndView province(@PathVariable("provinceId") int provinceId, Model model) {
        AreaStat areaStat = areaStatService.getAreaStatById(provinceId);
        model.addAttribute("areaStat", areaStat);
        return new ModelAndView("province", "provinceModel", model);
    }

    @GetMapping("/province/{provinceId}/{type}")
    public ResponseEntity<Response> getProvinceEpidemicMap(@PathVariable("provinceId") int provinceId, @PathVariable("type") String type) {
        try {
            List<CityInfo> cityInfos = cityInfoService.getCityInfoByProvinceId(provinceId);
            List<MapData> epidemicData = new ArrayList<>();
            for (CityInfo cityInfo : cityInfos) {
                if ("currentConfirmedCount".equals(type)) {
                    epidemicData.add(new MapData(cityInfo.getCityName(), cityInfo.getCurrentConfirmedCount()));
                } else if ("confirmedCount".equals(type)) {
                    epidemicData.add(new MapData(cityInfo.getCityName(), cityInfo.getConfirmedCount()));
                }
            }
            return ResponseEntity.ok(new Response(true, "省份数据获取成功！", epidemicData));
        } catch (Exception e) {
            log.error("省份数据获取失败！",e);
            return ResponseEntity.ok(new Response(false, "省份数据获取失败！"));
        }
    }

    @GetMapping("/province/table/{provinceId}/{type}")
    public ResponseEntity<Response> getProvinceEpidemicTable(@PathVariable("provinceId") int provinceId, @PathVariable("type") String type) {
        try {
                List<StatisticData> dataList = statisticDataService.getStatisticDataListByProvinceId(provinceId);
                Collections.reverse(dataList);
                LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
                if ("confirmedIncr".equals(type)) {
                    for (StatisticData data : dataList) {
                        map.put(data.getPublishDate(), data.getConfirmedIncr());
                    }
                } else if ("confirmedCount".equals(type)) {
                    for (StatisticData data : dataList) {
                        map.put(data.getPublishDate(), data.getConfirmedCount());
                    }
                } else if ("curedAndDead".equals(type)) {
                    LinkedHashMap<String, List<Integer>> cdMap = new LinkedHashMap<>();
                    for (StatisticData data : dataList) {
                        List<Integer> cdList = new ArrayList<>();
                        cdList.add(data.getCuredCount());
                        cdList.add(data.getDeadCount());
                        cdMap.put(data.getPublishDate(), cdList);
                    }
                    return ResponseEntity.ok(new Response(true, "省份历史数据获取成功！", cdMap));
                }
            return ResponseEntity.ok(new Response(true, "省份历史数据获取成功！", map));
        } catch (Exception e) {
            log.error("省份历史数据获取失败！",e);
            return ResponseEntity.ok(new Response(false, "省份历史数据获取失败！",e));
        }
    }
}
