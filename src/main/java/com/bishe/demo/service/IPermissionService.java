package com.bishe.demo.service;

import com.bishe.demo.model.Permission;
import com.bishe.demo.model.User;

import java.util.List;

public interface IPermissionService {
    
    List<Permission> selectPermissionByUserName(User user);
    
}
