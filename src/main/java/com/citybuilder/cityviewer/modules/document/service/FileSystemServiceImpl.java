package com.citybuilder.cityviewer.modules.document.service;

import com.citybuilder.cityviewer.modules.document.repository.DocumentRepository;
import com.citybuilder.cityviewer.modules.document.repository.FileSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.net.URL;

/**
 * Use to hendle all the file handling logic
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Service
public class FileSystemServiceImpl implements FileSystemService {

    @Value("${app.cityImagePath}")
    private String FILE_LOCATION;

    private String RESOURCES_DIR = FileSystemRepository.class.getResource("/")
            .getPath();

    @Autowired
    FileSystemRepository fileRepository;

    @Autowired
    DocumentRepository documentRepository;

    /**
     * Use to save file in given file loacation
     *
     * @param fileName
     * @param content
     * @return
     * @throws Exception
     */
    @Override
    public String saveFile(String fileName, byte[] content) throws Exception {
        String filePath = RESOURCES_DIR + FILE_LOCATION;
        fileRepository.save(filePath, fileName, content);
        return FILE_LOCATION;

    }

    /**
     * Use to download file from file location
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    @Override
    public InputStreamResource downloadFile(String filePath) throws Exception {
        BufferedInputStream in = new BufferedInputStream(new URL(filePath).openStream());
        return new InputStreamResource(in);
    }
}
