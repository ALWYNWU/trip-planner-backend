package com.trip_planner.service;

import com.trip_planner.Utils.WeatherVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface WeatherService {
    WeatherVo getCurrentWeather(Double lat, Double lon);
    List<WeatherVo> getAllWeather(Double lat, Double lon);
    WeatherVo getWeatherBySelectedDate(Double lat, Double lon, Long date);

}
