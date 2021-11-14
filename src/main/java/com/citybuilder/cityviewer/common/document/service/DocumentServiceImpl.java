package com.citybuilder.cityviewer.common.document.service;

import com.citybuilder.cityviewer.common.document.models.CityDocument;
import com.citybuilder.cityviewer.common.document.models.DocumentDto;
import com.citybuilder.cityviewer.common.document.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Value("${app.cityImageUrl}")
    private String FILE_URL;

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    FileSystemService fileSystem;
    @Override
    public void updateCityDocument(DocumentDto documentDto) throws Exception {
        documentDto.setName(documentDto.getUploadFile().getOriginalFilename());
        documentDto.setContent(documentDto.getUploadFile().getBytes());
        String fileName =  new Date().getTime() + "-" + documentDto.getName();
        String filePath = fileSystem.saveFile(fileName, documentDto.getContent());

        CityDocument doc = documentRepository.findById(documentDto.getId())
                .orElseThrow(() -> new RuntimeException("doc not found for this id :: " + documentDto.getId()));
        doc.setDocPath(FILE_URL+fileName);
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
       return fileSystem.downloadFile(doc.getDocPath());
    }

    @Override
    public List<CityDocument> getListOfDocByBelongsTo(Long belongsToId) {
       return  documentRepository.findByBelongsToId(belongsToId);
    }

}
