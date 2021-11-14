package com.citybuilder.cityviewer.common.document.service;

import com.citybuilder.cityviewer.common.document.models.CityDocument;
import com.citybuilder.cityviewer.common.document.models.DocumentDto;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import java.util.List;

@Service
public interface DocumentService {
    public List<CityDocument> getListOfDocByBelongsTo(Long belongsToIdList);
    public void updateCityDocument(DocumentDto documentDto)  throws Exception;
    public CityDocument getCityDocument(Long docId)  throws Exception;
    public InputStreamResource downloadFile(Long docId) throws Exception;
}
