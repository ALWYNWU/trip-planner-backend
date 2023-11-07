package com.trip_planner.controller;

import com.trip_planner.Utils.Constant;
import com.trip_planner.Utils.Response;
import com.trip_planner.Utils.WeatherVo;
import com.trip_planner.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin()
public class WeatherController {

    WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("/current")
    public Response getCurrentWeatherByCity(@Validated @RequestParam("lat") String lat,@Validated @RequestParam("lon") String lon){
        WeatherVo currentWeather = weatherService.getCurrentWeather(Double.parseDouble(lat), Double.parseDouble(lon));
        return Response.ok().put(Constant.DATA, currentWeather);
    }

    @GetMapping("/date")
    public Response getWeatherBySelectedDate(@Validated @RequestParam("lat") String lat,
                                             @Validated @RequestParam("lon") String lon,
                                             @Validated @RequestParam("date") String date){
        WeatherVo weather = weatherService.getWeatherBySelectedDate(Double.parseDouble(lat), Double.parseDouble(lon), Long.parseLong(date));
        return Response.ok().put(Constant.DATA, weather);
    }

}
