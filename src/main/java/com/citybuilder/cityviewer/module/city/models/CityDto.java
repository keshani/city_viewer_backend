package com.citybuilder.cityviewer.module.city.models;

import com.citybuilder.cityviewer.common.document.models.CityDocument;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
   private List<CityDocument> cityImages;
}
