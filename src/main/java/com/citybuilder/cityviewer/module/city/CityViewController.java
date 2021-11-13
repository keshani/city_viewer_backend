package com.citybuilder.cityviewer.module.city;

import com.citybuilder.cityviewer.common.controller.BaseConroller;
import com.citybuilder.cityviewer.module.city.models.City;
import com.citybuilder.cityviewer.module.city.models.CityDto;
import com.citybuilder.cityviewer.module.city.service.CityViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class CityViewController extends BaseConroller {

    @Autowired
    CityViewService cityViewService;

    @GetMapping("/fetchListOfCities")
    public ResponseEntity fetchCityList(CityDto cityDto) {
        Page<City> cityList = cityViewService.getListOfCityBySearchCriteria(cityDto);
        return ResponseEntity.ok().body(cityList);
    }

    @PutMapping("/updateCityInfo")
    public ResponseEntity updateCityInfo(@RequestBody CityDto cityDto) {
        cityViewService.updateCityInfo(cityDto);
        return ResponseEntity.ok().body("Successs");

    }
    @PutMapping("/uploadCityImages")
    public ResponseEntity<List<City>> uploadCityImages() {
        return ResponseEntity.ok().body(Collections.singletonList(new City(1L,"Tokiyo","Nice Country",0F,0F, "Japan" )));

    }

}
