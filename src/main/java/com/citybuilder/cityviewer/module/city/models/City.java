package com.citybuilder.cityviewer.module.city.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "CITY_INFO")
public class City implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "CITY_NAME")
    private String cityName;
    @Column(name = "CITY_DESCRIPTION")
    private String cityDescription;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "LATITUDE")
    private Float latitude;
    @Column(name = "LONGITUDE")
    private Float longitude;


    public City() {
    }

    public City(Long cityId, String cityName, String cityDescription, Float latitude, Float longitude, String country) {
        this.id = cityId;
        this.cityName = cityName;
        this.cityDescription = cityDescription;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
    }



}
