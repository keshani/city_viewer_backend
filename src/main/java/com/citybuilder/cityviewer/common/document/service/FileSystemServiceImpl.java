package com.citybuilder.cityviewer.common.document.service;

import com.citybuilder.cityviewer.common.document.models.CityDocument;
import com.citybuilder.cityviewer.common.document.models.DocumentDto;
import com.citybuilder.cityviewer.common.document.repository.DocumentRepository;
import com.citybuilder.cityviewer.common.document.repository.FileSystemRepository;
import com.citybuilder.cityviewer.module.city.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.Date;

@Service
public class FileSystemServiceImpl implements FileSystemService {

    @Value("${app.cityImagePath}")
    private String FILE_LOCATION;

    private String RESOURCES_DIR =  FileSystemRepository.class.getResource("/")
            .getPath();

    @Autowired
    FileSystemRepository fileRepository;

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public String saveFile(String fileName, byte[] content) throws Exception {
        String filePath = RESOURCES_DIR+FILE_LOCATION;
        fileRepository.save(filePath, fileName, content);
        return FILE_LOCATION;

    }

    @Override
    public InputStreamResource downloadFile(String filePath) throws Exception {
        BufferedInputStream in = new BufferedInputStream(new URL(filePath).openStream());
        return new InputStreamResource(in);
    }
}
