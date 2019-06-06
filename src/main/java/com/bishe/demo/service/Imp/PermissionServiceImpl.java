package com.bishe.demo.service.Imp;

import com.bishe.demo.dao.PermissionMapper;
import com.bishe.demo.model.Permission;
import com.bishe.demo.model.User;
import com.bishe.demo.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PermissionServiceImpl implements IPermissionService {

    @Autowired PermissionMapper permissionDao;

    @Override
    public List<Permission> selectPermissionByUserName(User user) {
        return permissionDao.selectPermissionsByUser(user);
    }

}
