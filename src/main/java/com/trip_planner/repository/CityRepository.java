package com.trip_planner.repository;

import com.trip_planner.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "SELECT c FROM City c WHERE c.name = :name")
    List<City> findByName(String name);

}
