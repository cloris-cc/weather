package com.jacky.weather.basic.vo;

import lombok.Data;

/**
 * @author Jacky
 * Date:   2018/12/24
 * Time:   23:55
 */
@Data
public class WeatherResponse {
    private Weather data;
    private Integer status;
    private String desc;
}
