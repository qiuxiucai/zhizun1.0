package com.ruoyi.project.market.indent.mapper;

import com.ruoyi.project.item.info.domain.Item;
import com.ruoyi.project.market.indent.domain.Clientele;
import com.ruoyi.project.market.indent.domain.IndentAllVO;
import com.ruoyi.project.product.details.domain.Goods;
import com.ruoyi.project.staff.message.domain.Staff;

import java.util.List;

public interface IndentMapper {
    List<IndentAllVO> selectAll();

    IndentAllVO selectByNum(Integer pid);

    IndentAllVO select();


    int addClientele(Clientele clientele);

    int addItem(Item item);

    int addGoods(Goods goods);
}
