package com.ruoyi.project.product.details.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.Data;

@Data
public class Goods extends BaseEntity {
    //产品主键
    private Integer productId;
    //产品型号(编号)
    private String productModel;
    //产品名称
    private String productName;
    //产品类型
    private String productType;
    //产品图片
    private String productUrl;
    //产品系列id外键
    private Integer productSeriesId;
    //产品风格id外键
    private Integer productStyleId;
    //产品规格id外键
    private Integer productSizeId;
    //产品材质
    private String productMaterials;
    //产品产地
    private String productArea;
    //产品单价
    private Long productPrice;
    //产品数量
    private Integer productNum;
    //产品总价
    private Long productTotalPrice;
    //产品状态
    private String productStatus;
    //添加产品备注
    private String productRemark;
}
