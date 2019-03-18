package com.jacky.weather.basic.service;

import com.jacky.weather.basic.vo.WeatherResponse;


/**
 * @author Jacky
 * Date:   2018/12/25
 * Time:   0:03
 */
public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);

    void syncData(String cityId);
}
