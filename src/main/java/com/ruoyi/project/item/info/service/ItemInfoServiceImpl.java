package com.ruoyi.project.item.info.service;

import com.ruoyi.project.item.info.mapper.ItemInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 项目信息查看service层实现类
 * 17361 19:53
 */
@Service
public class ItemInfoServiceImpl implements IItemInfoSerice{

    /**
     * 注入项目信息查看mapper层
     */
    @Autowired
    private ItemInfoMapper itemInfoMapper;

}
