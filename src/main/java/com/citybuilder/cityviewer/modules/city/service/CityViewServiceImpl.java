package com.citybuilder.cityviewer.modules.city.service;

import com.citybuilder.cityviewer.modules.document.models.CityDocument;
import com.citybuilder.cityviewer.modules.document.service.DocumentService;
import com.citybuilder.cityviewer.modules.city.repository.CityViewRepository;
import com.citybuilder.cityviewer.modules.city.models.City;
import com.citybuilder.cityviewer.modules.city.models.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

/**
 * Service layer to handle all the City operation logics
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Service
public class CityViewServiceImpl implements CityViewService {

    @Autowired
    CityViewRepository cityRepository;

    @Autowired
    DocumentService documentService;

    /**
     * Use to fetch pageble list of cities for given search criteirsa
     * From db
     *
     * @param cityDto
     * @return
     */
    @Override
    public Page<City> getListOfCityBySearchCriteria(CityDto cityDto) {
        Pageable pageable = PageRequest.of(cityDto.getPageNumber(), cityDto.getPageSize());
        Page<City> cityPage = cityRepository.findBySearchCriteria(cityDto.getCityName(), pageable);
        List<City> cityList = cityPage.getContent();
        Page<City> cityPageNew = cityPage.map(new Function<City, City>() {
            @Override
            public City apply(City entity) {
                List<CityDocument> docList = documentService.getListOfDocByBelongsTo(entity.getId());
                entity.setCityImages(docList);
                return entity;
            }
        });
        return cityPageNew;
    }

    /**
     * Use to update city information
     *
     * @param cityDto
     * @return
     */
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
