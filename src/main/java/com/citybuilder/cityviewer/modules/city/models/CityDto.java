package com.citybuilder.cityviewer.modules.city.models;

import com.citybuilder.cityviewer.modules.document.models.CityDocument;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * City Dto model to transfer data between client end and server
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Setter
@Getter
public class CityDto {
    private Long id;
    private String cityName;
    private String cityDescription;
    private String country;
    private Float latitude;
    private Float longitude;
    private int pageSize;
    private int pageNumber;
    private List<CityDocument> cityImages;
}
