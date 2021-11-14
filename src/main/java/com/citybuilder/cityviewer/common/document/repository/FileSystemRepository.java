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
    public String save(String filePath, String fileName, byte[] content) throws Exception {
        Path newFile = Paths.get( filePath+  fileName);
        Files.createDirectories(newFile.getParent());
        Files.write(newFile, content);
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