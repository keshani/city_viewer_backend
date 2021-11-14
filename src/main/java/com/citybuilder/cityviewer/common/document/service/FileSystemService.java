package com.citybuilder.cityviewer.common.document.service;

import com.citybuilder.cityviewer.common.document.models.CityDocument;
import com.citybuilder.cityviewer.common.document.models.DocumentDto;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface FileSystemService {
    public InputStreamResource downloadFile(String filePath)  throws Exception;
    public String saveFile(String fileName, byte[] content) throws Exception ;
}
