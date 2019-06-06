package com.bishe.demo.service;

import com.bishe.demo.common.util.Response.ResponseCode;
import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.model.User;

public interface ILoginService {

    public ResponseServer checkUser(User user);

    public ResponseServer login(User user);

    public ResponseServer register(User user);

    public ResponseServer resetPassword(User user);

    /**
     * 查询当前登录用户的权限等信息
     */
    public ResponseServer getInfo();

    public ResponseServer logout();
}
