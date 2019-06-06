package com.bishe.demo.dao;

import com.bishe.demo.model.FriendShipLink;

import java.util.List;

public interface FriendShipLinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FriendShipLink record);

    int insertSelective(FriendShipLink record);

    FriendShipLink selectByPrimaryKey(Integer id);
    
    List<FriendShipLink> selectAll();

    int updateByPrimaryKeySelective(FriendShipLink record);

    int updateByPrimaryKey(FriendShipLink record);
}