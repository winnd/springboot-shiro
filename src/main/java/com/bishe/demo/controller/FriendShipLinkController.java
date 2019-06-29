package com.bishe.demo.controller;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.model.FriendShipLink;
import com.bishe.demo.service.IFriendShipLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/friendShipLink")
public class FriendShipLinkController {

    @Autowired IFriendShipLinkService iFriendShipLinkService;


    @RequestMapping(value = "/select/all", method = RequestMethod.GET)
    public ResponseServer selectAll() {
        return iFriendShipLinkService.selectAllFriendShipLink();
    }


    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public ResponseServer selectByPrimaryKey(@PathVariable Integer id) {
        return iFriendShipLinkService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseServer insertFriendShipLink(FriendShipLink friendShipLink) {
        return iFriendShipLinkService.insert(friendShipLink);
    }


    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    public ResponseServer updateByPrimaryKey(FriendShipLink friendShipLink) {
        return iFriendShipLinkService.updateByPrimaryKey(friendShipLink);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ResponseServer deleteFriendShipLink(@PathVariable Integer id) {
        return iFriendShipLinkService.delectFriendShipLinkById(id);
    }

}