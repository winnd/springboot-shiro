package com.bishe.demo.service;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.model.Relic;
import org.springframework.web.multipart.MultipartFile;

public interface IRelicService {

    ResponseServer selectAllRelic(Integer pageNum, Integer pageSize);

    ResponseServer selectByRelicType(Integer i);

    ResponseServer selectByPrimaryKey(Integer id);

    ResponseServer insert(Relic relic, MultipartFile coverImg, MultipartFile[] imgList);

    ResponseServer updateByPrimaryKey(Relic relic);

    ResponseServer delectRelicById(Integer id);

}