package com.jacky.weather.basic.service.impl;

import com.jacky.weather.basic.service.WeatherDataService;
import com.jacky.weather.basic.service.WeatherReportService;
import com.jacky.weather.basic.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jacky
 * Date:   2018/12/27
 * Time:   22:45
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        return weatherDataService.getDataByCityId(cityId).getData();
    }
}
