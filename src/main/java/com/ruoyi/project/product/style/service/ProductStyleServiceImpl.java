package com.ruoyi.project.product.style.service;

import com.ruoyi.common.constant.StyleConstants;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.product.style.domain.ProductStyle;
import com.ruoyi.project.product.style.mapper.ProductStyleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductStyleServiceImpl implements IProductStyleServie {

    @Autowired
    private ProductStyleMapper productStyleMapper;

    @Override
    public List<ProductStyle> selectProductStyleAll() {
        return productStyleMapper.selectProductStyleAll();
    }

    @Override
    public List<ProductStyle> selectProductStyle(ProductStyle productStyle) {
        return productStyleMapper.selectProductStyle(productStyle);
    }

    @Override
    public AjaxResult saveProductStyle(ProductStyle productStyle, String userName) {
        //指定productStyle属性
        productStyle.setCreateBy(userName);
        int result = productStyleMapper.saveProductStyle(productStyle);
        if(result == 1){
            return AjaxResult.success("添加风格类型成功");
        }
        return AjaxResult.error("添加风格类型失败");
    }

    @Override
    public String checkProductStyleNameUnique(String styleName) {
        ProductStyle productStyle = productStyleMapper.selectProductStyleNameUnique(styleName);
        if(productStyle != null){
            return StyleConstants.STYLENAME_UNIQUE_EXISTS;
        }
        return StyleConstants.STYLENAME_UNIQUE_NOT_EXISTS;
    }

    @Override
    public ProductStyle selectProductStyleById(Long styleId) {
        return productStyleMapper.selectProductStyleById(styleId);
    }

    @Override
    public AjaxResult editStyleType(ProductStyle productStyle, String userName) {
        productStyle.setUpdateBy(userName);
        int result = productStyleMapper.updateProductStyle(productStyle);
        if(result == 1){
            return AjaxResult.success("修改风格类型成功");
        }
        return AjaxResult.error("修改风格类型失败");
    }

    @Override
    public AjaxResult removeStyleByIds(Long[] ids) {

        //        for (Long id : ids) {
//            Long num = seriesMapper.countProductDetails(ids);
//            if(num > 0){
//                return AjaxResult.error("该公告下有内容,不能删除");
//            }
//        }
        int result = productStyleMapper.removeStyleByIds(ids);
        if(result == ids.length){
            return AjaxResult.success("删除产品风格类型成功");
        }
        return AjaxResult.error("删除产品风格类型失败");
    }
}
