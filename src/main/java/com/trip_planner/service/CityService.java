package com.trip_planner.service;

import com.trip_planner.Utils.Response;
import com.trip_planner.entity.City;

import java.util.List;

public interface CityService {
    List<City> getCityList();
    boolean saveCity(City city);
    City getCityById(Long id);
    boolean updateCity(City city);
    boolean deleteCityById(Long id);
}
