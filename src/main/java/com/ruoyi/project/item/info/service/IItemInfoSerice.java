package com.ruoyi.project.item.info.service;

import com.ruoyi.project.item.info.domain.Item;
import com.ruoyi.project.item.info.domain.VO.ItemVO;

import java.util.List;

/**
 * 17361 19:53
 */
public interface IItemInfoSerice {
    List<ItemVO> list(Item item);

    ItemVO selectById(Integer pId);
}
