package com.bishe.demo.controller;


import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.service.IRelicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("relicType")
public class RelicTypeController {

    @Autowired IRelicTypeService iRelicTypeService;

    @RequestMapping(value = "select/all", method = RequestMethod.GET)
    public ResponseServer selectAll() {
        return iRelicTypeService.selectAll();
    }
    
}
