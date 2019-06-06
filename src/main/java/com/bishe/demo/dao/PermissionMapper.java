package com.bishe.demo.dao;

import com.bishe.demo.model.Permission;
import com.bishe.demo.model.User;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    List<Permission> selectPermissionsByUser(User user);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}