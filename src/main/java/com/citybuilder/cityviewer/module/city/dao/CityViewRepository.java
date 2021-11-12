package com.citybuilder.cityviewer.module.city.dao;

import com.citybuilder.cityviewer.module.city.models.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityViewRepository extends JpaRepository<City,Long> {
    Page<City> findByCityName(String cityName, Pageable pageable);

}

