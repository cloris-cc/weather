package com.jacky.weather.basic.service;

import com.jacky.weather.basic.vo.Weather;

/**
 * Designs for Thymeleaf Template.
 *
 * @author Jacky
 * Date:   2018/12/27
 * Time:   22:45
 */
public interface WeatherReportService {

    Weather getDataByCityId(String cityId);
}
