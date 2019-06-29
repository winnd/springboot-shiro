package com.bishe.demo.service.Imp;

import com.bishe.demo.common.util.Response.ResponseCode;
import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.common.util.tool.Time;
import com.bishe.demo.dao.RelicImageMapper;
import com.bishe.demo.dao.RelicMapper;
import com.bishe.demo.dao.util.UtilMapper;
import com.bishe.demo.model.Relic;
import com.bishe.demo.model.RelicImage;
import com.bishe.demo.service.IRelicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("iRelicService")
@PropertySource(value = {"classpath:application-dev.properties"})
public class RelicServiceImpl implements IRelicService {

    @Value("${upload.url}") public String uploadUrl;

    @Autowired RelicMapper relicDao;
    @Autowired RelicImageMapper relicImageDao;
    @Autowired UtilMapper utilDao;

    @Override
    public ResponseServer selectAllRelic() {
        List<Relic> relics = relicDao.selectAll();

        return relics.size() > 0 ?
                ResponseServer.createBySuccess("获取所有藏品数据成功", relics) :
                ResponseServer.createByErrorMsg("获取所有藏品数据失败");
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
            List<RelicImage> relicImages = relicImageDao.selectByPrimaryKey(id);
            if (relicImages != null) relic.setRelicImages(relicImages);
            relic.setRelicImages(relicImages);
            return ResponseServer.createBySuccess("根据id获取藏品数据成功", relic);
        } else {
            return ResponseServer.createByErrorMsg("根据id获取藏品数据失败");
        }
    }
    //① shiro 登录权限控制完成
//② xml中加入collection 查找 imgList (进行中)
//③ 完成上传文件配置及模块
//④ 解决登录跨域及 OPTIONS 问题
//⑤ 解决 getSecurityManage冲突问题
//⑥ 数据库中增加 sys_sequence 表 记录新增时的序号
    @Override
    public ResponseServer insert(Relic relic, MultipartFile coverImg, MultipartFile[] imgList) {

        try {
            Integer id = utilDao.getIdFromRelicTable("relic");
            relic.setId(id);

            if (coverImg != null) { relic.setPicUrl(_saveCoverImg(coverImg)); }                     // 存入封面url
            if (imgList.length != 0) {
                List<RelicImage> imageList = _saveImgList(imgList, relic.getId());                  // 存到本地 imgList
                relicImageDao.insertimgList(imageList);                                             // 存到数据库
            }

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseServer.createByErrorMsg(ResponseCode.UPLOAD_FAIL.getCode(), ResponseCode.UPLOAD_FAIL.getDesc());
        }
        return relicDao.insert(relic) == 1 ?
                ResponseServer.createBySuccessMsg("插入成功") :
                ResponseServer.createByErrorMsg("插入失败");
    }


    // 存封面图片到本地
    private String _saveCoverImg(MultipartFile coverImg) throws IOException {
        String coverImgReliativefileDir = uploadUrl + "cover" + File.separator + Time.getDir(File.separator);    // 封面目录路径 (绝对路径)
        return _saveFile(coverImg, coverImgReliativefileDir);
    }

    // 存 imgList 到本地
    private List<RelicImage> _saveImgList(MultipartFile[] imgList, Integer relicId) throws IOException {
        String imgListFileDir = uploadUrl + "imgList" + File.separator + Time.getDir(File.separator);

        List<RelicImage> relicImages = new ArrayList<>();
        for (MultipartFile multipartFile : imgList) {
            RelicImage relicImage = new RelicImage();
            relicImage.setRelicId(relicId);
            relicImage.setUrl(_saveFile(multipartFile, imgListFileDir));
            // todo 设置存入人和更改人  
            relicImages.add(relicImage);
        }
        return relicImages;
    }

    private String _saveFile(MultipartFile file, String dir) throws IOException {
        String coverImgFileName = System.currentTimeMillis() + file.getOriginalFilename();                   // 文件名
        File coverImgLocalSave = new File(dir + coverImgFileName);

        if (!coverImgLocalSave.exists()) {
            coverImgLocalSave.mkdirs();
        }

        file.transferTo(coverImgLocalSave);
        return coverImgLocalSave.getPath();
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
