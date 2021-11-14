package com.citybuilder.cityviewer.common.document;

import com.citybuilder.cityviewer.common.controller.BaseConroller;
import com.citybuilder.cityviewer.common.document.models.DocumentDto;
import com.citybuilder.cityviewer.common.document.service.DocumentService;
import com.citybuilder.cityviewer.common.document.service.FileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.net.URL;

@CrossOrigin
@RestController
public class DocumentController extends BaseConroller {

    @Autowired
    DocumentService documentService;

    @PostMapping("/uploadDocument")
    public void updateDocument(DocumentDto document, HttpServletRequest httpServletRequest) throws Exception {

        this.documentService.updateCityDocument(document);
//        String url = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Skyscrapers_of_Shinjuku_2009_January.jpg/500px-Skyscrapers_of_Shinjuku_2009_January.jpg";
//        String url2 = "http://localhost:9092/city-viewer/target/classes/1636626973551-uploadFile";
//        String url3 = "http://localhost:9092/uploadFile.txt";
//        BufferedInputStream in = new BufferedInputStream(new URL(url3).openStream());
//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "test")
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(new InputStreamResource(in));
    }

    @PostMapping("/downloadDocument")
    public ResponseEntity<Resource> downloadDocument(DocumentDto document, HttpServletRequest httpServletRequest) throws Exception {

        InputStreamResource in = this.documentService.downloadFile(document.getId());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "test")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(in);
    }

}
