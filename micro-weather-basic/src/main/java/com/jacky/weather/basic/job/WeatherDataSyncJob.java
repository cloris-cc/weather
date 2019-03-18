package com.jacky.weather.basic.job;

import com.jacky.weather.basic.service.CityDataService;
import com.jacky.weather.basic.service.WeatherDataService;
import com.jacky.weather.basic.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @author Jacky
 * Date:   2018/12/27
 * Time:   3:44
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherDataSyncJob.class);
    private static int counts = 1;

    @Autowired
    CityDataService cityDataService;

    @Autowired
    WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("Executed WeatherDataSyncJob " + (counts++) + " times.");

        List<City> cityList = null;

        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != cityList) {
            for (City city : cityList) {
                String cityId = city.getId();
                LOGGER.info("The cityId is: "+ cityId);
                weatherDataService.syncData(cityId);
            }
        }

        LOGGER.info("WeatherDataSyncJob Finished.");

    }
}
