package com.bishe.demo.service.Imp;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.dao.UserMapper;
import com.bishe.demo.model.User;
import com.bishe.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iUserService}")
public class UserServiceImpl implements IUserService {

    @Autowired UserMapper userDao;

    @Override
    public ResponseServer selectAllUser() {
        List<User> userList = userDao.selectAll();
        if (userList != null) {
            return ResponseServer.createBySuccess("获取所有user数据成功", userList);
        } else {
            return ResponseServer.createByErrorMsg("获取所有user数据失败");
        }
    }

    @Override
    public ResponseServer selectByPrimaryKey(Integer id) {
        User user = userDao.selectByPrimaryKey(id);
        if (user != null) {
            return ResponseServer.createBySuccess("根据id获取user数据成功", user);
        } else {
            return ResponseServer.createByErrorMsg("根据id获取user数据失败");
        }
    }

    @Override
    public ResponseServer insert(User user) {
        int isInserted = userDao.insert(user);
        if (isInserted == 1) {
            return ResponseServer.createBySuccessMsg("插入成功");
        } else {
            return ResponseServer.createByErrorMsg("插入失败");
        }
    }

    @Override
    public ResponseServer updateByPrimaryKey(User user) {

        int isInserted = userDao.updateByPrimaryKey(user);
        if (isInserted == 1) {
            return ResponseServer.createBySuccessMsg("修改成功");
        } else {
            return ResponseServer.createByErrorMsg("修改失败");
        }
    }

    @Override
    public ResponseServer delectUserById(Integer id) {

        int isInserted = userDao.deleteByPrimaryKey(id);
        if (isInserted == 1) {
            return ResponseServer.createBySuccessMsg("删除成功");
        } else {
            return ResponseServer.createByErrorMsg("删除失败");
        }
    }
}