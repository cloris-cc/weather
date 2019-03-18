package com.jacky.weather.basic.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This feign client is also needed to configure the HttpMessageConverter for the response type of Application/octet-stream.
 *
 * @author Jacky
 * Date:   2018/12/26
 * Time:   1:38
 */
@FeignClient(name = "feign-service",url = "http://wthrcdn.etouch.cn")
public interface FeignService {

    @GetMapping(value = "/weather_mini")
    ResponseEntity<Byte[]> getWeatherData(@RequestParam("citykey") String citykey); // ?citykey=101280601
}
