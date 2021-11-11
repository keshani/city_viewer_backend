package com.citybuilder.cityviewer.common.document;

import com.citybuilder.cityviewer.common.controller.BaseConroller;
import org.apache.coyote.Response;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

@CrossOrigin
@RestController
public class DocumentController extends BaseConroller {

    @Autowired
    FileSystemService fileSystem;

  //  @RequestMapping(path = "/uploadDocument", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    @PostMapping("/uploadDocument")
    public ResponseEntity uploadDocument(  DocumentDto document, HttpServletRequest httpServletRequest) throws Exception {
        this.fileSystem.saveImageFile(document.getUploadFile());
        String url = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Skyscrapers_of_Shinjuku_2009_January.jpg/500px-Skyscrapers_of_Shinjuku_2009_January.jpg";
        String url2 = "http://localhost:9092/city-viewer/target/classes/1636626973551-uploadFile";
        String url3 = "http://localhost:9092/resources/static/1636626973551-uploadFile";
        BufferedInputStream in = new BufferedInputStream(new URL(url3).openStream());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "test")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
}
