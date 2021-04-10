package com.yc.piclib.services;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FastefsClient {

    //storage
    @Autowired
    protected FastFileStorageClient storageClient;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    public String uplodFile(MultipartFile file) {
        //获取文件类型
        String fileType = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
        //存储地址
        StorePath path = null;
        try {
            //下载文件
            path = storageClient.uploadFile(file.getInputStream(), file.getSize(), fileType, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("uplodFile完成。。。。。。。。。。。");
        if (path != null) {
            return path.getFullPath();
        } else {
            return null;
        }

    }

    public String uplodFile(InputStream inputStream, Long size, String type) {
        StorePath path = null;
        try {
            path = storageClient.uploadFile(inputStream, size, type, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (path != null) {
            return path.getFullPath();
        } else {
            return null;
        }
    }

    /**
     * 删除文件
     *
     * @param fullPath
     */
    public void deleteFile(String fullPath) {
        storageClient.deleteFile(fullPath);
    }

}