package com.trip_planner.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Data
@Table(name = "City")
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "City name can not be empty")
    private String name;

    @Column(name = "description")
    @NotEmpty(message = "City description can not be empty")
    private String description;

    @Column(name = "country")
    @NotEmpty
    private String country;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lon")
    private String lon;


}
