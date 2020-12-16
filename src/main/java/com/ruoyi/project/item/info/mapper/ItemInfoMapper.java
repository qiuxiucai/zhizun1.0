package com.ruoyi.project.item.info.mapper;

import com.ruoyi.project.item.info.domain.Item;
import com.ruoyi.project.item.info.domain.VO.ItemVO;

import java.util.List;

/**
 * 项目信息查看实体类
 * 17361 19:55
 */
public interface ItemInfoMapper {


    List<ItemVO> list(Item item);

    ItemVO selectById(Integer pId);
}
