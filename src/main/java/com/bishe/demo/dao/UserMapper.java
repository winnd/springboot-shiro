package com.bishe.demo.dao;

import com.bishe.demo.model.User;

import java.util.List;

public interface UserMapper {
    
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    User checkLogin(User user);

    int checkAccount(String account);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}