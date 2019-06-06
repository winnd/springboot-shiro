package com.bishe.demo.controller;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.model.User;
import com.bishe.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired IUserService iUserService;


    @RequestMapping(value = "/select/all", method = RequestMethod.GET)
    public ResponseServer selectAll() {
        return iUserService.selectAllUser();
    }


    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public ResponseServer selectByPrimaryKey(@PathVariable Integer id) {
        return iUserService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseServer insertUser(User user) {
        return iUserService.insert(user);
    }


    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    public ResponseServer updateByPrimaryKey(User user) {
        System.out.println(user.getId());
        return iUserService.updateByPrimaryKey(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ResponseServer deleteUser(@PathVariable Integer id) {
        return iUserService.delectUserById(id);
    }

}