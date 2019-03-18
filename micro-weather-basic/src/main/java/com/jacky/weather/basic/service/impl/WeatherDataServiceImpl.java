package com.jacky.weather.basic.service.impl;

import com.jacky.weather.basic.service.WeatherDataService;
import com.jacky.weather.basic.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author Jacky
 * Date:   2018/12/25
 * Time:   0:05
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final static String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String url = WEATHER_URL + "citykey=" + cityId;
        return this.getData(url);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String url = WEATHER_URL + "city=" + cityName;
        return this.getData(url);
    }

    @Override
    public void syncData(String cityId) {
        String url = WEATHER_URL + "citykey=" + cityId;
        this.saveData(url);
    }

    private WeatherResponse getData(String url) {
        WeatherResponse data = (WeatherResponse) redisTemplate.opsForValue().get(url);
        if (StringUtils.isEmpty(data)) {
            data = restTemplate.getForObject(url, WeatherResponse.class);
            redisTemplate.opsForValue().set(url, data, 35L, TimeUnit.MINUTES);
        }
        return data;
    }

    /**
     * This method is designed for scheduled tasks.
     * Saves the newest weather date to Redis automatically.
     *
     * @param url Request URL.
     */
    private void saveData(String url) {
        WeatherResponse data = restTemplate.getForObject(url, WeatherResponse.class);
        if (!StringUtils.isEmpty(data)) {
            redisTemplate.opsForValue().set(url, data, 35L, TimeUnit.MINUTES);
        }
    }
}
