package com.citybuilder.cityviewer.module.city.service;

import com.citybuilder.cityviewer.module.city.repository.CityViewRepository;
import com.citybuilder.cityviewer.module.city.models.City;
import com.citybuilder.cityviewer.module.city.models.CityDto;
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
        return cityRepository.findBySearchCriteria(cityDto.getCityName(), pageable);
    }

    @Override
    public Boolean updateCityInfo(CityDto cityDto) {
        City cityInfo = cityRepository.findById(cityDto.getId())
                .orElseThrow(() -> new RuntimeException("City not found for this id :: " + cityDto.getId()));
        cityInfo.setCityName(cityDto.getCityName());
        cityInfo.setCityDescription(cityDto.getCityDescription());
        cityInfo.setCountry(cityDto.getCountry());
        cityInfo.setLatitude(cityDto.getLatitude());
        cityInfo.setLongitude(cityDto.getLongitude());
        cityRepository.save(cityInfo);
        return true;
    }
}
