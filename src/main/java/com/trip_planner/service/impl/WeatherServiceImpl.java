package com.trip_planner.service.impl;

import com.trip_planner.Utils.WeatherApiResponse;
import com.trip_planner.Utils.WeatherHelper;
import com.trip_planner.Utils.WeatherVo;
import com.trip_planner.service.WeatherService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    public WeatherVo getCurrentWeather(Double lat, Double lon){
        List<WeatherVo> allWeather = getAllWeather(lat, lon);
        return allWeather.get(0);
    }

    public List<WeatherVo> getAllWeather(Double lat, Double lon){
        WeatherApiResponse weatherApiResponse = WeatherHelper.getWeatherApiResponse(lat, lon);
        assert weatherApiResponse != null;
        return WeatherHelper.extractWeatherData(weatherApiResponse);
    }

    public WeatherVo getWeatherBySelectedDate(Double lat, Double lon, Long date){
        List<WeatherVo> allWeather = getAllWeather(lat, lon);
        if (date == 1) {
            return allWeather.get(1);
        } else if (date == 2) {
            return allWeather.get(2);
        } else if (date == 3) {
            return allWeather.get(3);
        } else {
            return allWeather.get(0);
        }
    }

}
