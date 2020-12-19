package com.ruoyi.project.product.details.mapper;

import com.ruoyi.project.product.details.domain.Goods;
import com.ruoyi.project.product.details.vo.GoodsVO;

import java.util.List;

public interface GoodsMapper {
    List<GoodsVO> selectGoodsVO(Goods goods);

    List<String> selectMaterialsAll();

    Goods checkProductModelNameUnique(String productModel);

    Goods checkProductNameUnique(String productName);

    int savegoods(Goods goods);

    Long countGoods(Long seriesId);

    Long countStyleGoods(Long styleId);

    Long countSizeGoods(Long sizeId);

    int updateGoods(Goods goods);

    GoodsVO selectGoodsById(Long productId);
}
