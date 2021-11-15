package com.citybuilder.cityviewer.modules.document.controller;

import com.citybuilder.cityviewer.common.controller.BaseConroller;
import com.citybuilder.cityviewer.modules.document.models.DocumentDto;
import com.citybuilder.cityviewer.modules.document.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Controller to handle all the City Document operations
 *
 * @author Keshani
 * @since 2021/11/13
 */

@CrossOrigin
@RestController
public class DocumentController extends BaseConroller {
    Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);
    @Autowired
    DocumentService documentService;

    /**
     * Rest end point use to upload document
     *
     * @param document
     * @param httpServletRequest
     * @return
     */
    @PostMapping("/documentHandler/uploadDocument")
    public ResponseEntity<HttpStatus> updateDocument(@Valid DocumentDto document, HttpServletRequest httpServletRequest) {
        try {
            this.documentService.updateCityDocument(document);
            LOGGER.info("DocumentController::updateDocument success - ", document.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("DocumentController::updateDocument failed", ex);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Rest end point to download document
     *
     * @param document
     * @param httpServletRequest
     * @return
     */
    @PostMapping("/documentHandler/downloadDocument")
    public ResponseEntity<Resource> downloadDocument(DocumentDto document, HttpServletRequest httpServletRequest) {
        InputStreamResource in = null;
        try {
            in = this.documentService.downloadFile(document.getId());
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "test")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(in);
        } catch (Exception ex) {
            LOGGER.error("DocumentController::downloadDocument failed", ex);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

}
