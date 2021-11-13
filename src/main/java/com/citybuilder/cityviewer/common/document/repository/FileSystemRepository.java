package com.citybuilder.cityviewer.common.document.repository;

import com.citybuilder.cityviewer.common.document.models.DocumentDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Repository
public class FileSystemRepository {

    @Value("${app.cityImagePath}")
    private String FILE_LOCATION;
    private String RESOURCES_DIR =  FileSystemRepository.class.getResource("/")
            .getPath();

    public String save(DocumentDto documentDto) throws Exception {
        String fileName = new Date().getTime() + "-" + documentDto.getName();
        Path newFile = Paths.get( RESOURCES_DIR+ FILE_LOCATION+  fileName);
        Files.createDirectories(newFile.getParent());
        Files.write(newFile, documentDto.getContent());
        return fileName;
    }

    public void delete(String filePath) throws Exception {
        try {
            Files.delete(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}