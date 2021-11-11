package com.citybuilder.cityviewer.module.city;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class City implements Serializable {

    private Integer cityId;
    private String cityName;
    private String cityDescription;
    private String country;
    private Float latitude;
    private Float longitude;


    public City(Integer cityId, String cityName, String cityDescription, Float latitude, Float longitude, String country) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityDescription = cityDescription;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
    }



}
