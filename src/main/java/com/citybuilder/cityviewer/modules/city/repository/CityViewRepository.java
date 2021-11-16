package com.citybuilder.cityviewer.modules.city.repository;

import com.citybuilder.cityviewer.modules.city.models.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository to handle all the City Entity related CRUD operations
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Repository
public interface CityViewRepository extends JpaRepository<City, Long> {
    Page<City> findByCityName(String cityName, Pageable pageable);

    @Query(value = "SELECT city"
            + " FROM City city"
            + " WHERE :cityName = NULL OR UPPER(city.cityName) LIKE (UPPER(CONCAT(:cityName, '%')))")
    Page<City> findBySearchCriteria(@Param("cityName") String cityName, Pageable pageable);

}

