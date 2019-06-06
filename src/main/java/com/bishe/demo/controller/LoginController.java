package com.bishe.demo.controller;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.model.User;
import com.bishe.demo.service.ILoginService;
import com.bishe.demo.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@ResponseBody
public class LoginController {

    @Autowired ILoginService iLoginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseServer login(@RequestBody User user) {
        return iLoginService.login(user);
    }

    @RequestMapping(value = "/getPermission",method = RequestMethod.POST)
    public ResponseServer getPermission() {
        return iLoginService.getInfo();
    }
}
