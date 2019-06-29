package com.bishe.demo.dao;

import com.bishe.demo.model.Relic;
import com.bishe.demo.model.RelicImage;

import java.util.List;

public interface RelicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Relic record);

    int insertSelective(Relic record);

    List<RelicImage> selectRelicImage(Integer id);
    
    Relic selectByPrimaryKey(Integer id);

    List<Relic> selectByRelicType(Integer relicType);

    int updateByPrimaryKeySelective(Relic record);

    int updateByPrimaryKey(Relic record);

    List<Relic> selectAll();
}