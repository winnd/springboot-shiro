package com.bishe.demo.controller;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.model.User;
import com.bishe.demo.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class LoginController {

    @Autowired ILoginService iLoginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseServer login(@RequestBody User user) {
        return iLoginService.login(user);
    }

    @RequestMapping(value = "/getPermission", method = RequestMethod.POST)
    public ResponseServer getPermission() {
        return iLoginService.getInfo();
    }

    // 下面的效果与 shiroconfig 中设置 setloginUrl('login.vue') 相同
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public void LoginRedirect(HttpServletResponse response) throws IOException {
//        response.sendRedirect("http://localhost:8083/login.vue");
//    }

//    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
//    public ResponseServer getUser() {
//        return iLoginService.getInfo();
//    }
}
