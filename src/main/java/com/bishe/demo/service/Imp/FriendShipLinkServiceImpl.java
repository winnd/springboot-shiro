package com.bishe.demo.service.Imp;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.dao.FriendShipLinkMapper;
import com.bishe.demo.model.FriendShipLink;
import com.bishe.demo.model.Relic;
import com.bishe.demo.service.IFriendShipLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iFriendShipLinkService}")
public class FriendShipLinkServiceImpl implements IFriendShipLinkService {

    @Autowired FriendShipLinkMapper friendShipLinkDao;

    @Override
    public ResponseServer selectAllFriendShipLink() {
        List<FriendShipLink> friendShipLinkList = friendShipLinkDao.selectAll();
        if (friendShipLinkList !=null) {
            return ResponseServer.createBySuccess("获取所有friendShipLink数据成功", friendShipLinkList);
        } else {
            return ResponseServer.createByErrorMsg("获取所有friendShipLink数据失败");
        }
    }

    @Override
    public ResponseServer selectByPrimaryKey(Integer id) {
        FriendShipLink friendShipLink = friendShipLinkDao.selectByPrimaryKey(id);
        if (friendShipLink != null) {
            return ResponseServer.createBySuccess("根据id获取friendShipLink数据成功", friendShipLink);
        } else {
            return ResponseServer.createByErrorMsg("根据id获取friendShipLink数据失败");
        }
    }

    @Override
    public ResponseServer insert(FriendShipLink friendShipLink) {
        int isInserted = friendShipLinkDao.insert(friendShipLink);
        if (isInserted == 1) {
            return ResponseServer.createBySuccessMsg("插入成功");
        } else {
            return ResponseServer.createByErrorMsg("插入失败");
        }
    }

    @Override
    public ResponseServer updateByPrimaryKey(FriendShipLink friendShipLink) {

        int isInserted = friendShipLinkDao.updateByPrimaryKey(friendShipLink);
        if (isInserted == 1) {
            return ResponseServer.createBySuccessMsg("修改成功");
        } else {
            return ResponseServer.createByErrorMsg("修改失败");
        }
    }

    @Override
    public ResponseServer delectFriendShipLinkById(Integer id) {

        int isInserted = friendShipLinkDao.deleteByPrimaryKey(id);
        if (isInserted == 1) {
            return ResponseServer.createBySuccessMsg("删除成功");
        } else {
            return ResponseServer.createByErrorMsg("删除失败");
        }
    }
}