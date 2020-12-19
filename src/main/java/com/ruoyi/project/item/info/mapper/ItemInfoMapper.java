package com.ruoyi.project.item.info.mapper;

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
 * 项目信息查看实体类
 * 17361 19:55
 */
public interface ItemInfoMapper {


    List<ItemVO> selectAll(Item item);

    ItemVO selectById(Integer pId);

    ItemAllVO selectByIdVO(Integer pid);

    List<ClienTeleAllVO> selectTypeAll();

    List<Goods> selectGoodsAll();

    int updataItemAll(Item item);

    int updataClienteleAll(ClienTeleAllVO clientele);
}
