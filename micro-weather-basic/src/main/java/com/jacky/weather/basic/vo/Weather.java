package com.jacky.weather.basic.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

/**
 * @author Jacky
 * Date:   2018/12/24
 * Time:   23:37
 */
@Data
public class Weather {
    private Yesterday yesterday;
    private String city;
    private String aqi;
    private List<Forecast> forecast;
    @JsonAlias("ganmao")
    private String cold;
    @JsonAlias("wendu")
    private String temperature;

}
