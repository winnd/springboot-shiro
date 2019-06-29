package com.bishe.demo.dao;

import com.bishe.demo.model.RelicImage;

import java.util.List;

public interface RelicImageMapper {
    int deleteByPrimaryKey(Integer imageId);

    int insert(RelicImage record);

    int insertimgList(List<RelicImage> imgList);            // 批量插入

    int insertSelective(RelicImage record);

    List<RelicImage> selectByPrimaryKey(Integer imageId);
    
    List<RelicImage> selectByRelicId(Integer relicId);
    
    int updateByPrimaryKeySelective(RelicImage record);

    int updateByPrimaryKey(RelicImage record);
}