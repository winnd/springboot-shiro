package com.bishe.demo.common.shiro;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.dao.UserMapper;
import com.bishe.demo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class UserRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired UserMapper userDao;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        try {
            Session session = SecurityUtils.getSubject().getSession();
            
            HashMap permissionMap = (HashMap) session.getAttribute("currentUserAllPermissions");

            ObjectMapper objectMapper = new ObjectMapper();
            String permissionStr = objectMapper.writeValueAsString(permissionMap);

            JsonNode permissionJson = objectMapper.readTree(permissionStr);

            System.out.println(permissionJson);

            logger.info("permission的值为: " + permissionStr);
            logger.info("本用户权限为: " + permissionJson.get("permissionList").asText());

            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            
            authorizationInfo.addStringPermissions((Collection<String>) permissionMap.get("permissionList"));

            return authorizationInfo;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    // 验证当前登录的Subject
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String loginName = (String) authenticationToken.getPrincipal();

        String password = new String((char[]) authenticationToken.getCredentials());

        User loginUser = userDao.checkLogin(new User(loginName, password));

        if (loginUser == null)
            throw new UnknownAccountException();

        SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(loginName, password, getName());

        loginUser.setPassword(null);        // 密码设为空

        SecurityUtils.getSubject().getSession().setAttribute("userInfo", loginUser);     // 用户信息存到session中

        return authorizationInfo;
    }
}
