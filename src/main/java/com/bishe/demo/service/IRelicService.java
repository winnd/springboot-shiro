package com.bishe.demo.service;

import com.bishe.demo.common.util.Response.ResponseServer;
import com.bishe.demo.model.Relic;

public interface IRelicService {
    
    public ResponseServer selectAllRelic();
    
    public ResponseServer selectByRelicType(Integer i);
    
    public ResponseServer selectByPrimaryKey(Integer id);

    public ResponseServer insert(Relic relic);
    
    public ResponseServer updateByPrimaryKey(Relic relic);

    public ResponseServer delectRelicById(Integer id);

}