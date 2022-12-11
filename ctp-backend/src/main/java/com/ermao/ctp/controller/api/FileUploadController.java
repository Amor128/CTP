package com.ermao.ctp.controller.api;

import com.ermao.ctp.service.FileUploadService;
import com.ermao.ctp.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @author Ermao
 * Date: 2022/12/10 14:27
 */
@Slf4j
@RestController
public class FileUploadController {

    private FileUploadService fileUploadService;

    @Autowired
    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/api/files")
    public Response handleFileUpload(@RequestParam("file") MultipartFile file) {
        log.debug("get file {}", file.getName());

        String filename = fileUploadService.uploadFile(file);
        HashMap<String, String> map = new HashMap<>();
        map.put("url", filename);
        return Response.ok(map);
    }
}
