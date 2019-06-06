package com.bishe.demo.service;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.model.FriendShipLink;

public interface IFriendShipLinkService {

    public ResponseServer selectAllFriendShipLink();

    public ResponseServer selectByPrimaryKey(Integer id);

    public ResponseServer insert(FriendShipLink friendShipLink);

    public ResponseServer updateByPrimaryKey(FriendShipLink friendShipLink);

    public ResponseServer delectFriendShipLinkById(Integer id);

}