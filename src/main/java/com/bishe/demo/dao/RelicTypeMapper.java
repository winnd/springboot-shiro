package com.bishe.demo.dao;

import com.bishe.demo.model.RelicType;

import java.util.List;

public interface RelicTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RelicType record);

    int insertSelective(RelicType record);

    RelicType selectByPrimaryKey(Integer id);

    List<RelicType> selectAll();

    int updateByPrimaryKeySelective(RelicType record);

    int updateByPrimaryKey(RelicType record);
}