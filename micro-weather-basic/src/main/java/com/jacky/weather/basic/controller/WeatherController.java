package com.jacky.weather.basic.controller;

import com.jacky.weather.basic.service.WeatherDataService;
import com.jacky.weather.basic.service.FeignService;
import com.jacky.weather.basic.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jacky
 * Date:   2018/12/25
 * Time:   2:03
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherDataService weatherDataService;

    @Autowired
    FeignService feignService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }


    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable String cityId) {
        return weatherDataService.getDataByCityId(cityId);

    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }

    @GetMapping("/test")
    public ResponseEntity<Byte[]> getWeatherData(@RequestParam("cityId") String cityId) {
        return feignService.getWeatherData(cityId);
    }


}
