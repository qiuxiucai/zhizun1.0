package com.ruoyi.project.product.style.mapper;

import com.ruoyi.project.product.style.domain.ProductStyle;

import java.util.List;

public interface ProductStyleMapper {
    //查询所有
    List<ProductStyle> selectProductStyleAll();

    //条件查询
    List<ProductStyle> selectProductStyle(ProductStyle productStyle);

    //新增
    int saveProductStyle(ProductStyle productStyle);

    //校验
    ProductStyle selectProductStyleNameUnique(String styleName);

    //选中的哪个id修改时数据回显到表单
    ProductStyle selectProductStyleById(Long styleId);

    //更新
    int updateProductStyle(ProductStyle productStyle);

    //删除
    int removeStyleByIds(Long[] ids);
}
