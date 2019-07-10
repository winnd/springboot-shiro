package com.bishe.demo.controller;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.model.Relic;
import com.bishe.demo.service.IRelicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@ResponseBody
@RequestMapping("/relic")
public class RelicController {

    @Autowired IRelicService iRelicService;

    @GetMapping(value = "select/allRelic")
    public ResponseServer selectAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return iRelicService.selectAllRelic(pageNum, pageSize);
    }

    @GetMapping(value = "select/relicType")
    public ResponseServer selectByRelicType(@RequestParam("relicType") Integer relicType) {
        return iRelicService.selectByRelicType(relicType);
    }

    @GetMapping(value = "/select")
    public ResponseServer selectByPrimaryKey(@RequestParam Integer id) {
        return iRelicService.selectByPrimaryKey(id);
    }


    @PostMapping(value = "/addNew")
    public ResponseServer insertRelic2(
            @RequestPart(name = "formData") Relic relic,
            @RequestParam(name = "coverImg", required = false) MultipartFile coverImg,
            @RequestParam(name = "imgList", required = false) MultipartFile[] imgList) {
        return iRelicService.insert(relic, coverImg, imgList);
    }

    @PostMapping(value = "/updateById")
    public ResponseServer updateByPrimaryKey(Relic relic) {
        return iRelicService.updateByPrimaryKey(relic);
    }

    @DeleteMapping(value = "/delete")
    public ResponseServer deleteRelic(Integer id) {
        return iRelicService.delectRelicById(id);
    }

}
