package com.bishe.demo.service.Imp;

import com.bishe.demo.common.util.FTPUtil;
import com.bishe.demo.service.IFileService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service("iFileService")
public class IFileServiceImpl implements IFileService {

    @Override
    public String uploadFile(MultipartFile file, String path) throws IOException {
        String newFileName = System.currentTimeMillis() + file.getOriginalFilename();       // 目标文件名 时间戳+原文件名
        File fileDir = new File(path + newFileName);                              // 新目录 + 文件名.后缀, 

        if (!fileDir.exists()) {                                // 创建本地缓存文件夹
            fileDir.mkdirs();
        }
        
        File targetFile = new File(path, newFileName);          // 原版的拷贝, 要存的是这份, 本地缓存, 成功存入ftp服务器后删除

        file.transferTo(targetFile);                            // 把临时文件转存到目标文件夹中

        // 上传到ftp文件服务器上
        FTPUtil.uploadFile(Lists.newArrayList(targetFile));         // 已上传
        
        // 删除本地缓存文件
        targetFile.delete();

        return targetFile.getName();
    }
}
