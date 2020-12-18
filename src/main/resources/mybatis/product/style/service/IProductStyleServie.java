package com.ruoyi.project.product.style.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.product.style.domain.ProductStyle;

import java.util.List;

public interface IProductStyleServie {

    List<ProductStyle> selectProductStyleAll();

    List<ProductStyle> selectProductStyle(ProductStyle productStyle);

    AjaxResult saveProductStyle(ProductStyle productStyle, String userName);

    String checkProductStyleNameUnique(String productStyleName);

    ProductStyle selectProductStyleById(Long styleId);

    AjaxResult editStyleType(ProductStyle productStyle, String userName);

    AjaxResult removeStyleByIds(Long[] ids);

}

