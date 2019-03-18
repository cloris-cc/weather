package com.jacky.weather.basic.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jacky
 * Date:   2018/12/27
 * Time:   9:38
 */
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class City {
    @XmlAttribute(name = "d1")
    private String id;
    @XmlAttribute(name = "d2")
    private String name;
    @XmlAttribute(name = "d3")
    private String code;
    @XmlAttribute(name = "d4")
    private String province;
}
