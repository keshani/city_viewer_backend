package com.citybuilder.cityviewer.module.city.service;

import com.citybuilder.cityviewer.module.city.models.City;
import com.citybuilder.cityviewer.module.city.models.CityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CityViewService {
    Page<City> getListOfCityBySearchCriteria(CityDto cityDto);
    Boolean updateCityInfo(CityDto cityDto);
}
