package com.ruoyi.project.item.info.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.item.info.domain.Item;
import com.ruoyi.project.item.info.domain.VO.ClienTeleAllVO;
import com.ruoyi.project.item.info.domain.VO.ItemAllVO;
import com.ruoyi.project.item.info.domain.VO.ItemVO;
import com.ruoyi.project.market.indent.domain.Clientele;
import com.ruoyi.project.product.details.domain.Goods;
import com.ruoyi.project.staff.message.domain.Staff;

import java.util.List;

/**
 * 17361 19:53
 */
public interface IItemInfoSerice {
    List<ItemVO> list(Item item);

    ItemVO selectById(Integer pId);

    ItemAllVO selectByIdVO(Integer pid);

    AjaxResult EditAll(Item item, ClienTeleAllVO clientele);
}
