package com.ruoyi.project.product.details.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.product.details.domain.Goods;
import com.ruoyi.project.product.details.vo.GoodsVO;

import java.util.List;

public interface IGoodsService {
    List<GoodsVO> selectGoodsVO(Goods goods);

    List<String> selectMaterialsAll();

    String checkProductModelNameUnique(String productModel);

    String checkProductNameUnique(String productName);

    AjaxResult savegoods(Goods goods, String userName);

    AjaxResult editGoods(Goods goods, String userName);

    GoodsVO selectGoodsById(Long productId);
}
