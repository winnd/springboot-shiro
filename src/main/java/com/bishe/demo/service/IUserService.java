package com.bishe.demo.service;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.model.User;

public interface IUserService {

    public ResponseServer selectAllUser();

    public ResponseServer selectByPrimaryKey(Integer id);

    public ResponseServer insert(User user);

    public ResponseServer updateByPrimaryKey(User user);

    public ResponseServer delectUserById(Integer id);

}