package com.trip_planner.controller;
import com.trip_planner.Utils.Constant;
import com.trip_planner.Utils.Response;
import com.trip_planner.entity.City;
import com.trip_planner.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "City request")
@RestController
@RequestMapping("/api/city")
@CrossOrigin()
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @Operation(summary = "Get city list")
    @GetMapping("/list")
    public Response getCityList(){
        List<City> cityList = cityService.getCityList();
        return Response.ok().put(Constant.DATA, cityList);
    }

    @Operation(summary = "Get specific city by city id")
    @GetMapping()
    public Response getCityById(@RequestParam("cityId") Long id){
        City city = cityService.getCityById(id);
        return Response.ok().put(Constant.DATA, city);
    }

    @Operation(summary = "Create a new city")
    @PostMapping("/save")
    public Response saveCity(@Validated @RequestBody City city){
       boolean res = cityService.saveCity(city);
       if (res){
           return Response.ok(Constant.SAVE_SUCCESS);
       } else {
           return Response.error(400, Constant.INVALID_CITY_NAME_MSG);
       }
    }

    @Operation(summary = "Update the city")
    @PostMapping("/update")
    public Response updateCity(@Validated @RequestBody City city){
        boolean res = cityService.updateCity(city);
        if (res){
            return Response.ok(Constant.UPDATE_SUCCESS);
        } else {
            return Response.error(400, Constant.ERROR_MSG);
        }
    }

    @Operation(summary = "Delete the city")
    @DeleteMapping("/delete")
    public Response deleteCityById(@RequestParam("cityId") Long id){
        boolean res = cityService.deleteCityById(id);
        if (res){
            return Response.ok(Constant.DELETE_SUCCESS);
        } else {
            return Response.error(400, Constant.ERROR_MSG);
        }
    }

}
