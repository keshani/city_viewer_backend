package com.citybuilder.cityviewer.modules.document.repository;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Use to handle saving and retriving file object from file storage
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Repository
public class FileSystemRepository {
    public String save(String filePath, String fileName, byte[] content) throws Exception {
        Path newFile = Paths.get(filePath + fileName);
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