package com.ruoyi.project.item.info.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.item.info.domain.Item;
import com.ruoyi.project.item.info.domain.VO.ClienTeleAllVO;
import com.ruoyi.project.item.info.domain.VO.ItemAllVO;
import com.ruoyi.project.item.info.domain.VO.ItemVO;
import com.ruoyi.project.item.info.mapper.ItemInfoMapper;
import com.ruoyi.project.market.indent.domain.Clientele;
import com.ruoyi.project.market.type.service.IIndentTypeService;
import com.ruoyi.project.market.type.service.IndentTypeServiceImpl;
import com.ruoyi.project.product.details.domain.Goods;
import com.ruoyi.project.staff.message.domain.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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


    /**
     * 注入订单service
     */
    @Autowired
    private IndentTypeServiceImpl indentTypeService;


    @Override
    public List<ItemVO> list(Item item) {
        return itemInfoMapper.selectAll(item);
    }

    @Override
    public ItemVO selectById(Integer pId) {
        return itemInfoMapper.selectById(pId);
    }

    @Override
    public ItemAllVO selectByIdVO(Integer pid) {
        ItemAllVO itemAllVO = itemInfoMapper.selectByIdVO(pid);
        itemAllVO.setTotalPrice(itemAllVO.getDAmount() * itemAllVO.getProductPrice());
        return itemAllVO;
    }

    @Override
    public AjaxResult EditAll(Item item, ClienTeleAllVO clientele) {
        //根据传入的dtype查询订单主键
       Clientele clientele1 = indentTypeService.selectByTypeID(clientele.getDType());
       item.setPDid(clientele1.getCId());
       //传入item typeid 更新客户表typeid
        int i = itemInfoMapper.updataItemAll(item);

        int i1 = itemInfoMapper.updataClienteleAll(clientele);
        if (i > 0 && i1 > 0){
            return AjaxResult.success("更新成功");
        }

        return AjaxResult.error("更新失败");
    }


    /**
     * 查询客户名称
     */
   public List<ClienTeleAllVO> selectTypeAll(){
       return itemInfoMapper.selectTypeAll();
    }

    /**
     * 查询产品信息
     */
    public List<Goods> selectGoodsAll(){
       return itemInfoMapper.selectGoodsAll();
    }
}
