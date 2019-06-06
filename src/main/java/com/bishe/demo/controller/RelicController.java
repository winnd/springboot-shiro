package com.bishe.demo.controller;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.model.Relic;
import com.bishe.demo.service.IRelicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;

@Controller
@ResponseBody
@RequestMapping("/relic")
public class RelicController {

    @Autowired IRelicService iRelicService;


    @RequestMapping(value = "select/all", method = RequestMethod.GET)
    public ResponseServer selectAll() {
        return iRelicService.selectAllRelic();
    }

    @RequestMapping(value = "select/relicType/{relicType}", method = RequestMethod.GET)
    public ResponseServer selectByRelicType(@PathVariable Integer relicType) {
        return iRelicService.selectByRelicType(relicType);
    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public ResponseServer selectByPrimaryKey(@PathVariable Integer id) {
        return iRelicService.selectByPrimaryKey(id);
    }


//    @RequestMapping(value = "/resources", method = RequestMethod.GET)
//    public ResponseServer<Relic> getResource(
//            @RequestParam(value = "relicId", required = false) Integer relicId, // postman里传参数
//            @RequestBody(value = "name", required = false) String name
//            @RequestBody User user    // json 对象
//    ) {
//        Object aa = new HashMap<>();
//        return ResponseServer.createBySuccessMsg("测试成功");
//    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseServer insertRelic(Relic relic) {
        return iRelicService.insert(relic);
    }



    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    public ResponseServer updateByPrimaryKey(Relic relic) {
        System.out.println(relic.getId());
        return iRelicService.updateByPrimaryKey(relic);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseServer deleteRelic(Integer id) {
        return iRelicService.delectRelicById(id);
    }

}
