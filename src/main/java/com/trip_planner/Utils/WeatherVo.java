package com.trip_planner.Utils;

import lombok.Data;

import java.util.Date;

@Data
public class WeatherVo {
    private String time;
    private String main;
    private double temp;
    private double feelsLike;
    private String description;
    private String sunrise;
    private String sunset;
}
