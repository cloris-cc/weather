package com.jacky.weather.basic.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * @author Jacky
 * Date:   2018/12/24
 * Time:   23:44
 */
@Data
public class Forecast {
    private String date;
    @JsonAlias("high")
    private String highest;
    @JsonAlias("fengxiang")
    private String windDirection;
    @JsonAlias("low")
    private String lowest;
    @JsonAlias("fengli")
    private String windForce;
    private String type;

}
