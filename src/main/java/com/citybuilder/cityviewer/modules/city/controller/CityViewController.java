package com.citybuilder.cityviewer.modules.city.controller;

import com.citybuilder.cityviewer.common.controller.BaseConroller;
import com.citybuilder.cityviewer.modules.city.models.City;
import com.citybuilder.cityviewer.modules.city.models.CityDto;
import com.citybuilder.cityviewer.modules.city.service.CityViewService;
import com.citybuilder.cityviewer.modules.document.controller.DocumentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class to handle all the City view operations
 *
 * @author Keshani
 * @since 2021/11/13
 */

@CrossOrigin
@RestController
public class CityViewController extends BaseConroller {

    Logger LOGGER = LoggerFactory.getLogger(CityViewController.class);
    @Autowired
    CityViewService cityViewService;

    /**
     * Rest and point Use to fetch city list
     *
     * @param cityDto
     * @return List of Cities as Pagable object
     */
    @GetMapping("/cityViewHandler/fetchListOfCities")
    public ResponseEntity fetchCityList(@Valid CityDto cityDto) {
        try {
            Page<City> cityList = cityViewService.getListOfCityBySearchCriteria(cityDto);
            return ResponseEntity.ok().body(cityList);
        } catch (Exception ex) {
            LOGGER.error("CityViewController::fetchCityList Error", ex);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    /**
     * Rest API use to update city information
     *
     * @param cityDto
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ALLOW_EDIT')")
    @PutMapping("/cityViewHandler/updateCityInfo")
    public ResponseEntity updateCityInfo(@Valid @RequestBody CityDto cityDto) {
        try {
            cityViewService.updateCityInfo(cityDto);
            LOGGER.info("CityViewController::updateCityInfo Sucess - ", cityDto.getId());
            return ResponseEntity.ok().body(null);
        } catch (Exception ex) {
            LOGGER.info("CityViewController::updateCityInfo Error - ", cityDto.getId());
            return ResponseEntity.status(500).body(null);
        }
    }

}
