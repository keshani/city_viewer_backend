package com.citybuilder.cityviewer.modules.city.service;

import com.citybuilder.cityviewer.modules.city.models.City;
import com.citybuilder.cityviewer.modules.city.models.CityDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface CityViewService {
    Page<City> getListOfCityBySearchCriteria(CityDto cityDto);

    Boolean updateCityInfo(CityDto cityDto);
}
