package com.ruoyi.project.market.indent.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.item.info.domain.Item;
import com.ruoyi.project.market.indent.domain.Clientele;
import com.ruoyi.project.market.indent.domain.IndentAllVO;
import com.ruoyi.project.product.details.domain.Goods;
import com.ruoyi.project.staff.message.domain.Staff;

import java.util.List;

public interface IIndentService {
    List<IndentAllVO> selectAll();

    IndentAllVO selectByNum(Integer pid);

    IndentAllVO select();


    AjaxResult addAll(Item item, Clientele clientele, Goods goods);
}
