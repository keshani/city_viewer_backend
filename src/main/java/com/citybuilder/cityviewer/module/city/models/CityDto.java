package com.citybuilder.cityviewer.module.city.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
public class CityDto {
   private Long id;
   private String cityName;
   private String cityDescription;
   private String country;
   private Float latitude;
   private Float longitude;
   private int pageSize;
   private int pageNumber;
}
