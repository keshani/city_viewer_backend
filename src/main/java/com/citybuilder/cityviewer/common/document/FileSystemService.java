package com.citybuilder.cityviewer.common.document;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface FileSystemService {

    String saveImageFile(@RequestParam MultipartFile multipartImage)  throws Exception;
}
