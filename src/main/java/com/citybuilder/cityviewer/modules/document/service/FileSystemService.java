package com.citybuilder.cityviewer.modules.document.service;

import org.springframework.core.io.InputStreamResource;

/**
 * Use to hendle all the file handling logic
 *
 * @author Keshani
 * @since 2021/11/13
 */
public interface FileSystemService {
    public InputStreamResource downloadFile(String filePath) throws Exception;

    public String saveFile(String fileName, byte[] content) throws Exception;
}
