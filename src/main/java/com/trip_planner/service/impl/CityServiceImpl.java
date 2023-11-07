package com.trip_planner.service.impl;

import com.trip_planner.Utils.Constant;
import com.trip_planner.Utils.GeoHelper;
import com.trip_planner.Utils.Response;
import com.trip_planner.entity.City;
import com.trip_planner.repository.CityRepository;
import com.trip_planner.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    CityRepository cityRepository;
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCityList() {
        return cityRepository.findAll();
    }

    public City checkCityExist(City city){
        List<City> byName = cityRepository.findByName(city.getName());
        if (!byName.isEmpty()){
            for (City c : byName) {
                if (c.getCountry() == city.getCountry() && c.getName() == city.getName()){
                    return city;
                }
            }
        }
        return null;
    }
    public boolean saveCity(City city) {
        try {
            City check = checkCityExist(city);
            if (check != null){
                check.setDescription(city.getDescription());
                cityRepository.save(check);
                return true;
            } else {
                String[] geoInfo = GeoHelper.getGeoInfoByCityAndCountryName(city.getName(), city.getCountry());
                if (geoInfo != null) {
                    city.setLat(geoInfo[0]);
                    city.setLon(geoInfo[1]);

                    if (city.getName() != geoInfo[2]) {
                        city.setName(geoInfo[2]);
                    }

                    cityRepository.save(city);
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e){
            return false;
        }
    }

    public City getCityById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        if (city.isPresent()) {
            return city.get();
        } else {
            return null;
        }
    }

    public boolean updateCity(City city) {
        City res = getCityById(city.getId());
        res.setDescription(city.getDescription());
        try {
            cityRepository.save(res);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean deleteCityById(Long id) {
        try {
            cityRepository.deleteById(id);
        } catch (Exception e){
            return false;
        }
        return true;

    }

}
