package com.travelagency.tirana.service.files;

import com.travelagency.tirana.service.files.FileUploadException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void save(MultipartFile file) throws FileUploadException;

    Resource load(String filename);
}
