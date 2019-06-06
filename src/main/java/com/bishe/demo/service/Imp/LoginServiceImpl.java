package com.bishe.demo.service.Imp;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.dao.PermissionMapper;
import com.bishe.demo.dao.UserMapper;
import com.bishe.demo.model.Permission;
import com.bishe.demo.model.User;
import com.bishe.demo.service.ILoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iLoginService")
public class LoginServiceImpl implements ILoginService {


    @Autowired UserMapper userDao;

    @Autowired PermissionMapper permissionDao;

    @Override
    public ResponseServer checkUser(User user) {
//        int hasUser = userDao.checkAccount(user.getAccount());
//
//        if (hasUser > 0) {
//            return ResponseServer.createByErrorMsg("该用户名已被使用");
//        } else {
//            return ResponseServer.createBySuccessMsg("注册成功");
//        }

        return null;
    }


    @Override
    public ResponseServer login(User user) {
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());
        try {
            currentUser.login(token);
            return ResponseServer.createBySuccessMsg("登录成功");
        } catch (AuthenticationException e) {
            return ResponseServer.createByErrorMsg("登录失败,请检查用户名及密码");
        }
    }


    @Override
    public ResponseServer register(User user) {
        int hasUser = userDao.checkAccount(user.getAccount());

        if (hasUser > 0) {
            return ResponseServer.createByErrorMsg("该用户名已被使用");
        } else {
            int inserted = userDao.insert(user);
            if (inserted == 1) {
                return ResponseServer.createBySuccessMsg("注册成功");
            } else {
                return ResponseServer.createByErrorMsg("注册失败");
            }
        }
    }


    @Override
    public ResponseServer resetPassword(User user) {
        int updated = userDao.updateByPrimaryKey(user);
        if (updated == 1) {
            return ResponseServer.createBySuccessMsg("密码重置成功");
        } else {
            return ResponseServer.createByErrorMsg("密码重置失败");
        }
    }

    @Override
    public ResponseServer getInfo() {
        Session session = SecurityUtils.getSubject().getSession();
        User currentUser = (User) session.getAttribute("userInfo");
        String accountName = currentUser.getName();

        List<Permission> permissions = permissionDao.selectPermissionsByUser(new User(accountName));
        session.setAttribute("userPermission", permissions);

        return ResponseServer.createBySuccess("用户权限列表", permissions);
    }

    @Override
    public ResponseServer logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return ResponseServer.createBySuccess("登出成功");
    }

}
