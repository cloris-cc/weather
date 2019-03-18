package com.jacky.weather.basic;

import com.jacky.weather.basic.service.WeatherDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author Jacky
 * Date:   2018/12/25
 * Time:   2:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class WeatherApplicationTests {

//    @Autowired
//    WeatherDataService weatherDataService;
//
//    @Test
//    public void test() throws IOException {
//        System.out.println(weatherDataService.getDataByCityId("101280601"));
//    }
}
