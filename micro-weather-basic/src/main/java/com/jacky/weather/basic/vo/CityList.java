package com.jacky.weather.basic.vo;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author Jacky
 * Date:   2018/12/27
 * Time:   9:44
 */
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CityList {
    @XmlElement(name = "d")
    private List<City> cityList;
}
