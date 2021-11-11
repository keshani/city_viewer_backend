package com.citybuilder.cityviewer.common.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileSystemServiceImpl implements FileSystemService{

    @Autowired
    FileSystemRepository fileRepository;

    @Override
    public String saveImageFile(@RequestParam MultipartFile multipartImage) throws Exception {
        ImageFile dbImage = new ImageFile();
        dbImage.setName(multipartImage.getName());
        dbImage.setContent(multipartImage.getBytes());

        return fileRepository.save(dbImage);
    }
}