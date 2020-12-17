package com.ruoyi.project.product.size.mapper;

import com.ruoyi.project.product.size.domain.ProductSize;

import java.util.List;

public interface ProductSizeMapper {

    //查询所有
    List<ProductSize> selectProductSizeAll();

    //条件查询
    List<ProductSize> selectProductSize(ProductSize productSize);

    //新增
    int saveProductSize(ProductSize productSize);

    //校验
    ProductSize selectProductSizeNameUnique(String SizeName);

    //选中的哪个id修改时数据回显到表单
    ProductSize selectProductSizeById(Long SizeId);

    //更新
    int updateProductSize(ProductSize productSize);

    //删除
    int removeSizeByIds(Long[] ids);

//    List<ProductSize> selectProductSizeAll();
}
