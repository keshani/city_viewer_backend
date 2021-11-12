package com.citybuilder.cityviewer.common.document;

import com.citybuilder.cityviewer.common.document.models.ImageFile;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Repository
class FileSystemRepository {

    String RESOURCES_DIR = FileSystemRepository.class.getResource("/")
            .getPath();

    String save(ImageFile imageFile) throws Exception {
        Path newFile = Paths.get(RESOURCES_DIR + new Date().getTime() + "-" + imageFile.getName());
        Files.createDirectories(newFile.getParent());
        Files.write(newFile, imageFile.getContent());
        return newFile.toAbsolutePath().toString();
    }
}