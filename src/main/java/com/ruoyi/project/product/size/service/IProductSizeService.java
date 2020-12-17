package com.ruoyi.project.product.size.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.product.size.domain.ProductSize;
import com.ruoyi.project.product.style.domain.ProductStyle;

import java.util.List;

public interface IProductSizeService {

    List<ProductSize> selectProductSizeAll();

    List<ProductSize> selectProductSize(ProductSize productSize);

    AjaxResult saveProductSize(ProductSize productSize, String userName);

    String checkProductSizeNameUnique(String sizeName);

    ProductSize selectProductSizeById(Long sizeId);

    AjaxResult editSizeType(ProductSize productSize, String userName);

    AjaxResult removeSizeByIds(Long[] ids);

}
