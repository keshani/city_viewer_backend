package com.citybuilder.cityviewer.modules.document.service;

import com.citybuilder.cityviewer.modules.document.models.CityDocument;
import com.citybuilder.cityviewer.modules.document.models.DocumentDto;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Use to hendle all the Document handling logic
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Service
public interface DocumentService {
    public List<CityDocument> getListOfDocByBelongsTo(Long belongsToIdList);

    public void updateCityDocument(DocumentDto documentDto) throws Exception;

    public CityDocument getCityDocument(Long docId) throws Exception;

    public InputStreamResource downloadFile(Long docId) throws Exception;
}
