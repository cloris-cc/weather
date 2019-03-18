package com.jacky.weather.basic.service.impl;

import com.jacky.weather.basic.service.CityDataService;
import com.jacky.weather.basic.util.XmlBuilder;
import com.jacky.weather.basic.vo.City;
import com.jacky.weather.basic.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Jacky
 * Date:   2018/12/27
 * Time:   10:11
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    /**
     * Reads the XMl file and parses it to POJO.
     *
     * @return cityList
     * @throws Exception IOException
     */
    @Override
    public List<City> listCity() throws Exception {
        Resource resource = new ClassPathResource("cityList.xml");
        BufferedReader reader= new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();

        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line); //
        }
        reader.close();

        CityList cityList = (CityList) XmlBuilder.build(CityList.class, buffer.toString());

        return cityList.getCityList();
    }
}
