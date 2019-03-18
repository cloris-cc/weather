package com.jacky.weather.basic.service;

import com.jacky.weather.basic.vo.City;

import java.util.List;

/**
 * @author Jacky
 * Date:   2018/12/27
 * Time:   10:05
 */
public interface CityDataService {

    List<City> listCity() throws Exception;
}
