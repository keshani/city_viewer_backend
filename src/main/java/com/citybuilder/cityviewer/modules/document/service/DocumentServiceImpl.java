package com.citybuilder.cityviewer.modules.document.service;

import com.citybuilder.cityviewer.modules.document.models.CityDocument;
import com.citybuilder.cityviewer.modules.document.models.DocumentDto;
import com.citybuilder.cityviewer.modules.document.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Use to hendle all the Document handling logic
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Value("${app.cityImageUrl}")
    private String FILE_URL;

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    FileSystemService fileSystem;

    /**
     * Use to handle city document update in db level and file storage
     *
     * @param documentDto
     * @throws Exception
     */
    @Override
    public void updateCityDocument(DocumentDto documentDto) throws Exception {
        documentDto.setName(documentDto.getUploadFile().getOriginalFilename());
        documentDto.setContent(documentDto.getUploadFile().getBytes());
        String fileName = new Date().getTime() + "-" + documentDto.getName();
        String filePath = fileSystem.saveFile(fileName, documentDto.getContent());

        CityDocument doc = documentRepository.findById(documentDto.getId())
                .orElseThrow(() -> new RuntimeException("doc not found for this id :: " + documentDto.getId()));
        doc.setDocPath(FILE_URL + fileName);
        doc.setBelongsToId(documentDto.getBelongsToId());
        doc.setDocType(documentDto.getType());
        doc.setName(documentDto.getName());
        documentRepository.save(doc);
    }

    /**
     * Use to retrive City Document through the document ID
     *
     * @param docId
     * @return
     * @throws Exception
     */

    @Override
    public CityDocument getCityDocument(Long docId) throws Exception {
        return this.documentRepository.findById(docId).get();
    }

    /**
     * Use to handle file download logics
     *
     * @param docId
     * @return
     * @throws Exception
     */
    @Override
    public InputStreamResource downloadFile(Long docId) throws Exception {
        CityDocument doc = documentRepository.findById(docId)
                .orElseThrow(() -> new RuntimeException("doc not found for this id :: " + docId));
        return fileSystem.downloadFile(doc.getDocPath());
    }

    /**
     * Use to get list of document by document belongs to object id
     *
     * @param belongsToId
     * @return
     */
    @Override
    public List<CityDocument> getListOfDocByBelongsTo(Long belongsToId) {
        return documentRepository.findByBelongsToId(belongsToId);
    }

}
