package com.bishe.demo.service.Imp;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.dao.RelicMapper;
import com.bishe.demo.model.Relic;
import com.bishe.demo.service.IRelicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iRelicService")
public class RelicServiceImpl implements IRelicService {

    @Autowired RelicMapper relicDao;

    @Override
    public ResponseServer selectAllRelic() {
        List<Relic> relics = relicDao.selectAll();
        if (relics.size() > 0) {
            return ResponseServer.createBySuccess("获取所有藏品数据成功", relics);
        } else {
            return ResponseServer.createByErrorMsg("获取所有藏品数据失败");
        }
    }

    @Override
    public ResponseServer selectByRelicType(Integer i) {
        List<Relic> relic = relicDao.selectByRelicType(i);
        if (relic != null) {
            return ResponseServer.createBySuccess("根据relicType获取藏品数据成功", relic);
        } else {
            return ResponseServer.createByErrorMsg("根据relicType获取藏品数据失败");
        }
    }

    @Override
    public ResponseServer selectByPrimaryKey(Integer id) {
        Relic relic = relicDao.selectByPrimaryKey(id);
        if (relic != null) {
            return ResponseServer.createBySuccess("根据id获取藏品数据成功", relic);
        } else {
            return ResponseServer.createByErrorMsg("根据id获取藏品数据失败");
        }
    }

    @Override
    public ResponseServer insert(Relic relic) {
        int isInserted = relicDao.insert(relic);
        if (isInserted == 1) {
            return ResponseServer.createBySuccessMsg("插入成功");
        } else {
            return ResponseServer.createByErrorMsg("插入失败");
        }
    }
                 
    @Override
    public ResponseServer updateByPrimaryKey(Relic relic) {

        int isInserted = relicDao.updateByPrimaryKey(relic);
        if (isInserted == 1) {
            return ResponseServer.createBySuccessMsg("修改成功");
        } else {
            return ResponseServer.createByErrorMsg("修改失败");
        }
    }

    @Override
    public ResponseServer delectRelicById(Integer id) {

        int isInserted = relicDao.deleteByPrimaryKey(id);
        if (isInserted == 1) {
            return ResponseServer.createBySuccessMsg("删除成功");
        } else {
            return ResponseServer.createByErrorMsg("删除失败");
        }
    }
}
