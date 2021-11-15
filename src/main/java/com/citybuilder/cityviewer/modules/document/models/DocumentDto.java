package com.citybuilder.cityviewer.modules.document.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * DTO model to pass client side data to server end
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Getter
@Setter
public class DocumentDto {
    private Long id;
    @NonNull
    private MultipartFile uploadFile;
    @NonNull
    private Long belongsToId;
    private String type;
    private byte[] content;
    private String imageType;
    private String name;
}
