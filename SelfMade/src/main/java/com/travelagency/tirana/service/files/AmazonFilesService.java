package com.travelagency.tirana.service.files;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public class AmazonFilesService implements FileService{
    @Override
    public void save(MultipartFile file) throws FileUploadException {

    }

    @Override
    public Resource load(String filename) {
        return null;
    }
}
