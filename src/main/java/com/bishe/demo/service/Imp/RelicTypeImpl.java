package com.bishe.demo.service.Imp;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.dao.RelicTypeMapper;
import com.bishe.demo.model.RelicType;
import com.bishe.demo.service.IRelicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iRelicTypeService")
public class RelicTypeImpl implements IRelicTypeService {

    @Autowired RelicTypeMapper relicTypeDao;

    @Override
    public ResponseServer selectAll() {
        List<RelicType> relicTypeList = relicTypeDao.selectAll();
        if (relicTypeList != null) {
            return ResponseServer.createBySuccess("获取relicType成功", relicTypeList);
        } else {
            return ResponseServer.createByErrorMsg("获取relicType失败");
        }
    }

}
