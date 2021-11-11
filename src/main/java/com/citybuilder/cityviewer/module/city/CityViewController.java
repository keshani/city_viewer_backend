package com.citybuilder.cityviewer.module.city;

import com.citybuilder.cityviewer.common.controller.BaseConroller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class CityViewController extends BaseConroller {

    @GetMapping("/fetchListOfCities")
    public ResponseEntity<List<City>> fetchCityList() {

        return ResponseEntity.ok().body(Collections.singletonList(new City(1,"Tokiyo","Nice Country",0F,0F, "Japan" )));

    }
}
