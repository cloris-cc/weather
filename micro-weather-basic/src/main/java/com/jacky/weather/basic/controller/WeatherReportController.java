package com.jacky.weather.basic.controller;

import com.jacky.weather.basic.service.CityDataService;
import com.jacky.weather.basic.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jacky
 * Date:   2018/12/27
 * Time:   22:49
 */
@Controller
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    WeatherReportService weatherReportService;

    @Autowired
    CityDataService cityDataService;

    @GetMapping("/cityId/{cityId}")
    public String getReportByCityId(@PathVariable String cityId, Model model) throws Exception{
        model.addAttribute("title", "Jacky Weather");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return "/weather/report";
    }
}
