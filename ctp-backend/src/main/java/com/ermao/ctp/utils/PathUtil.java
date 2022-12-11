package com.ermao.ctp.utils;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Ermao
 * Date: 2022/12/10 15:16
 */
public class PathUtil {

    public static String getUploadPath() {
        File path = new File("d:/tmp/ctp/");
        if (!path.exists()) {
            path = new File("d:/tmp/ctp/");
        }
        //如果上传目录为src/main/resources/upload/,则可以如下获取
        File upload = new File(path.getAbsolutePath(), "upload/");
        if (!upload.exists()) {
            upload.mkdirs();
        }
        String uploadPath = upload.getAbsolutePath();
        return uploadPath;
    }
}
