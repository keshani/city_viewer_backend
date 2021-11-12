package com.citybuilder.cityviewer.module.city.service;

import com.citybuilder.cityviewer.module.city.dao.CityViewRepository;
import com.citybuilder.cityviewer.module.city.models.City;
import com.citybuilder.cityviewer.module.city.models.CityDto;
import com.citybuilder.cityviewer.module.city.service.CityViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityViewServiceImpl implements CityViewService {

    @Autowired
    CityViewRepository cityRepository;

    @Override
    public Page<City> getListOfCityBySearchCriteria(CityDto cityDto) {
        Pageable pageable = PageRequest.of(cityDto.getPageNumber(), cityDto.getPageSize());
        return cityRepository.findByCityName(cityDto.getCityName(), pageable);
    }
}
