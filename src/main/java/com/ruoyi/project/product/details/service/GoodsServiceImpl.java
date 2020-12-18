package com.ruoyi.project.product.details.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.product.details.domain.Goods;
import com.ruoyi.project.product.details.mapper.GoodsMapper;
import com.ruoyi.project.product.details.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goods")
public class GoodsServiceImpl implements IGoodsService{

    //注入mapper
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsVO> selectGoodsVO(Goods goods) {

        //直接联表查询
        List<GoodsVO> list = goodsMapper.selectGoodsVO(goods);
        return list;
    }

    @Override
    public List<String> selectMaterialsAll() {
        return goodsMapper.selectMaterialsAll();
    }

    @Override
    public String checkProductModelNameUnique(String productModel) {
        Goods goods = goodsMapper.checkProductModelNameUnique(productModel);
        if(goods != null){
            return "1";
        }
        return "0";
    }

    @Override
    public String checkProductNameUnique(String productName) {
        Goods goods = goodsMapper.checkProductNameUnique(productName);
        if (goods != null) {
            return "1";
        }
        return "0";
    }

    @Override
    public AjaxResult savegoods(Goods goods, String userName) {
        goods.setProductUrl("images/1.png");
        goods.setCreateBy(userName);

        int result = goodsMapper.savegoods(goods);
        if(result == 1){
            return AjaxResult.success("新增产品成功");
        }
        return AjaxResult.error("新增产品失败");
    }

    @Override
    public AjaxResult editGoods(Goods goods, String userName) {
        goods.setUpdateBy(userName);
        int result = goodsMapper.updateGoods(goods);
        if(result == 1){
            return AjaxResult.success("修改产品详情成功");
        }
        return AjaxResult.error("修改产品详情失败");
    }

    @Override
    public GoodsVO selectGoodsById(Long productId) {
        return goodsMapper.selectGoodsById(productId);
    }
}
