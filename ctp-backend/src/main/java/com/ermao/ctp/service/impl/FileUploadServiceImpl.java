package com.ermao.ctp.service.impl;

import com.ermao.ctp.service.FileUploadService;
import com.ermao.ctp.utils.PathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ermao
 * Date: 2022/12/10 14:31
 */
@Slf4j
@Service
public class FileUploadServiceImpl implements FileUploadService {

    private static final String SUFFIX = ".jpg";

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");


    @Override
    public String uploadFile(MultipartFile file) {
        // 检查当天的文件夹是否存在，不存在就创建
        String uploadPath = PathUtil.getUploadPath();
        File filePath = new File(uploadPath);
        if (!filePath.exists()) {
            //若不存在文件夹，则创建一个文件夹
            filePath.mkdir();
        }
        filePath = new File(uploadPath + "/" + dateFormat.format(new Date()));
        //判断当天日期的文件夹是否存在，若不存在，则创建
        if (!filePath.exists()) {
            //若不存在文件夹，则创建一个文件夹
            filePath.mkdir();
        }

        String filename =dateFormat.format(new Date()) + "/" + System.currentTimeMillis() + SUFFIX;
        try {
            file.transferTo(new File(uploadPath + "/" + filename));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("图片上传成功，保存位置：" + uploadPath + filename);

        return "/file/upload/" + filename;
    }
}
