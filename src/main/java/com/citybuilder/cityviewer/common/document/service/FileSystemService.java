package com.citybuilder.cityviewer.common.document.service;

import com.citybuilder.cityviewer.common.document.models.CityDocument;
import com.citybuilder.cityviewer.common.document.models.DocumentDto;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface FileSystemService {
    public void updateCityDocument(DocumentDto documentDto)  throws Exception;
    public CityDocument getCityDocument(Long docId)  throws Exception;
    public InputStreamResource downloadFile(Long docId)  throws Exception;
}
