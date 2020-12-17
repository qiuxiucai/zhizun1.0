package com.ruoyi.project.product.size.service;

import com.ruoyi.common.constant.SizeConstants;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.product.size.domain.ProductSize;
import com.ruoyi.project.product.size.mapper.ProductSizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSizeServiceImpl implements IProductSizeService{


    @Autowired
    private ProductSizeMapper productSizeMapper;

    @Override
    public List<ProductSize> selectProductSizeAll() {
        return productSizeMapper.selectProductSizeAll();
    }

    @Override
    public List<ProductSize> selectProductSize(ProductSize productSize) {
        return productSizeMapper.selectProductSize(productSize);
    }

    @Override
    public AjaxResult saveProductSize(ProductSize productSize, String userName) {
        //指定productSize属性
        productSize.setCreateBy(userName);
        int result = productSizeMapper.saveProductSize(productSize);
        if(result == 1){
            return AjaxResult.success("添加规格类型成功");
        }
        return AjaxResult.error("添加规格类型失败");
    }

    @Override
    public String checkProductSizeNameUnique(String SizeName) {
        ProductSize productSize = productSizeMapper.selectProductSizeNameUnique(SizeName);
        if(productSize != null){
            return SizeConstants.SIZENAME_UNIQUE_EXISTS;
        }
        return SizeConstants.SIZENAME_UNIQUE_NOT_EXISTS;
    }


    @Override
    public ProductSize selectProductSizeById(Long sizeId) {
        return productSizeMapper.selectProductSizeById(sizeId);
    }



    @Override
    public AjaxResult editSizeType(ProductSize productSize, String userName) {
        productSize.setUpdateBy(userName);
        int result = productSizeMapper.updateProductSize(productSize);
        if(result == 1){
            return AjaxResult.success("修改规格类型成功");
        }
        return AjaxResult.error("修改规格类型失败");
    }

    @Override
    public AjaxResult removeSizeByIds(Long[] ids) {

        //        for (Long id : ids) {
//            Long num = seriesMapper.countProductDetails(ids);
//            if(num > 0){
//                return AjaxResult.error("该公告下有内容,不能删除");
//            }
//        }
        int result = productSizeMapper.removeSizeByIds(ids);
        if(result == ids.length){
            return AjaxResult.success("删除产品规格成功");
        }
        return AjaxResult.error("删除产品规格失败");
    }
}
