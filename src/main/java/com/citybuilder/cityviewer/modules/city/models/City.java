package com.citybuilder.cityviewer.modules.city.models;

import com.citybuilder.cityviewer.modules.document.models.CityDocument;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * City entity to store City data
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Getter
@Setter
@Entity
@Table(name = "CITY_INFO")
public class City implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
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

    @Transient
    private List<CityDocument> cityImages;

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
