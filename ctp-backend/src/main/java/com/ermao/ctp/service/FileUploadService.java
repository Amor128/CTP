package com.ermao.ctp.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Ermao
 * Date: 2022/12/10 14:30
 */
public interface FileUploadService {
    String uploadFile(MultipartFile file);
}
