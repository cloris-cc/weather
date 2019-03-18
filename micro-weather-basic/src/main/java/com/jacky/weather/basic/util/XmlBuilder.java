package com.jacky.weather.basic.util;

import org.springframework.util.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * Parses XMLString to POJO.
 *
 * @author Jacky
 * Date:   2018/12/27
 * Time:   9:50
 */
public class XmlBuilder {

    public static Object build(Class<?> clazz, String xmlStr) throws Exception {
        Unmarshaller unmarshaller = JAXBContext.newInstance(clazz).createUnmarshaller();
        Reader reader = new StringReader(xmlStr);
        Object xmlObject = unmarshaller.unmarshal(reader);

        if(!StringUtils.isEmpty(reader)) {
            reader.close();
        }

        return  xmlObject;
    }
}
