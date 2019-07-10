package com.bishe.demo.service.Imp;

import com.bishe.demo.common.util.Response.ResponseCode;
import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.common.util.tool.Time;
import com.bishe.demo.dao.RelicImageMapper;
import com.bishe.demo.dao.RelicMapper;
import com.bishe.demo.dao.util.UtilMapper;
import com.bishe.demo.model.Relic;
import com.bishe.demo.model.RelicImage;
import com.bishe.demo.service.IFileService;
import com.bishe.demo.service.IRelicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("iRelicService")
@PropertySource(value = {"classpath:application-dev.properties"})
public class RelicServiceImpl implements IRelicService {

    @Value("${upload.url}") public String uploadUrl;
    @Value("${ftp.server.http.prefix}") public String ftpPrefix;

    @Autowired IFileService fileService;
    @Autowired RelicMapper relicDao;
    @Autowired RelicImageMapper relicImageDao;
    @Autowired UtilMapper utilDao;

    @Override
    public ResponseServer selectAllRelic(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<Relic> relics = relicDao.selectAll();

        PageInfo pageResult = new PageInfo(relics);


        return ResponseServer.createBySuccess("获取所有藏品数据成功", pageResult);
    }

    @Override
    public ResponseServer selectByRelicType(Integer i) {
        List<Relic> relics = relicDao.selectByRelicType(i);

        if (relics != null) {
            List<Relic> relicList = relics.stream()
                    .peek(x -> {
                        List<RelicImage> images = relicImageDao.selectByRelicId(x.getId());
                        x.setRelicImages(images);
                    })
                    .collect(Collectors.toList());
            return ResponseServer.createBySuccess("根据relicType获取藏品数据成功", relicList);
        } else {
            return ResponseServer.createByErrorMsg("根据relicType获取藏品数据失败");
        }
    }

    @Override
    public ResponseServer selectByPrimaryKey(Integer id) {
        Relic relic = relicDao.selectByPrimaryKey(id);
        if (relic != null) {
            return ResponseServer.createBySuccess("根据id获取藏品数据成功", relic);
        } else {
            return ResponseServer.createByErrorMsg("根据id获取藏品数据失败");
        }
    }

    @Override
    public ResponseServer insert(Relic relic, MultipartFile coverImg, MultipartFile[] imgList) {

        try {
            Integer relicId = utilDao.getIdFromRelicTable("relic");          // 从数据库获取 relic id
            relic.setId(relicId);

            // 存入封面url
            if (coverImg != null) {
                String targetDir = uploadUrl + "cover" + File.separator + Time.getDir(File.separator);  // 本地缓存路径 (上传ftp服务器成功后会删除
                String imgName = fileService.uploadFile(coverImg, targetDir);
                relic.setPicUrl(ftpPrefix + imgName);
            }

            // 存入 imgList
            if (imgList.length != 0) {
                String targetDir = uploadUrl + "imgList" + File.separator + Time.getDir(File.separator);
                List<RelicImage> relicImages = new ArrayList<>();

                for (MultipartFile multipartFile : imgList) {
                    RelicImage relicImage = new RelicImage();
                    relicImage.setRelicId(relicId);
                    String imgName = fileService.uploadFile(multipartFile, targetDir);
                    relicImage.setUrl(ftpPrefix + imgName);
                    // todo 设置存入人和更改人
                    relicImages.add(relicImage);
                }

                relicImageDao.insertimgList(relicImages);                                             // 存到数据库
            }

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseServer.createByErrorMsg(ResponseCode.UPLOAD_FAIL.getCode(), ResponseCode.UPLOAD_FAIL.getDesc());
        }
        return relicDao.insert(relic) == 1 ?
                ResponseServer.createBySuccessMsg("插入成功") :
                ResponseServer.createByErrorMsg("插入失败");
    }


    @Override
    public ResponseServer updateByPrimaryKey(Relic relic) {

        return relicDao.updateByPrimaryKey(relic) == 1 ?
                ResponseServer.createBySuccessMsg("修改成功") :
                ResponseServer.createByErrorMsg("修改失败");
    }


    @Override
    public ResponseServer delectRelicById(Integer id) {

        return relicDao.deleteByPrimaryKey(id) == 1 ?
                ResponseServer.createBySuccessMsg("删除成功") :
                ResponseServer.createByErrorMsg("删除失败");
    }
}
