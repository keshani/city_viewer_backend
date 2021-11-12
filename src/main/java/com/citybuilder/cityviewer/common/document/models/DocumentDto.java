package com.citybuilder.cityviewer.common.document.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class DocumentDto {
    private Long id;
    private String imagePath;
    private String name;
    private MultipartFile uploadFile;

}
