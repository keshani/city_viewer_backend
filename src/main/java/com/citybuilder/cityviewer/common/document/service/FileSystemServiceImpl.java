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

@Service
public class FileSystemServiceImpl implements FileSystemService {

    @Value("${app.cityImageUrl}")
    private String FILE_URL;
    @Autowired
    FileSystemRepository fileRepository;

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public void updateCityDocument(DocumentDto documentDto) throws Exception {
        documentDto.setName(documentDto.getUploadFile().getOriginalFilename());
        documentDto.setContent(documentDto.getUploadFile().getBytes());
        String filePath  = fileRepository.save(documentDto);

        CityDocument doc = documentRepository.findById(documentDto.getId())
                .orElseThrow(() -> new RuntimeException("doc not found for this id :: " + documentDto.getId()));
        fileRepository.delete(doc.getDocPath());
        doc.setDocPath(FILE_URL+filePath);
        doc.setBelongsToId(documentDto.getBelongsToId());
        doc.setDocType(documentDto.getType());
        doc.setName(documentDto.getName());
        documentRepository.save(doc);
    }

    @Override
    public CityDocument getCityDocument(Long docId) throws Exception {
        return this.documentRepository.findById(docId).get();
    }

    @Override
    public InputStreamResource downloadFile(Long docId) throws Exception {
        CityDocument doc = documentRepository.findById(docId)
                .orElseThrow(() -> new RuntimeException("doc not found for this id :: " + docId));
        BufferedInputStream in = new BufferedInputStream(new URL(doc.getDocPath()).openStream());
        return new InputStreamResource(in);
    }
}
