package com.citybuilder.cityviewer.common.document.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class DocumentDto {
    private Long id;
    private MultipartFile uploadFile;
    private Long belongsToId;
    private String type;
    private byte[] content;
    private String imageType;
    private String name;
}
