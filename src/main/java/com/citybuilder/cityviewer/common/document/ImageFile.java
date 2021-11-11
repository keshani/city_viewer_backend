package com.citybuilder.cityviewer.common.document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageFile {
        Long id;
        String imagePath;
        String name;
        byte[] content;
}
