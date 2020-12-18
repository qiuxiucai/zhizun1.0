package com.ruoyi.project.product.details.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
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

//      `pro_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品主键',
//            `pro_model` varchar(255) NOT NULL COMMENT '产品型号',
//            `pro_name` varchar(255) NOT NULL COMMENT '产品名称',
//            `pro_type` varchar(255) NOT NULL COMMENT '产品类别',
//            `pro_images` varchar(255) NOT NULL COMMENT '产品图片',
//            `productseries_id` int(11) NOT NULL COMMENT '系列id',
//            `productstyle_id` int(11) NOT NULL COMMENT '风格id',
//            `productsize_id` int(11) NOT NULL COMMENT '规格id',
//            `pro_materials` varchar(255) NOT NULL COMMENT '产品材质',
//            `pro_area` varchar(255) NOT NULL COMMENT '产品产地',
//            `pro_price` decimal(10,2) DEFAULT NULL COMMENT '产品单价',
//            `pro_num` int(11) DEFAULT NULL COMMENT '产品数量',
//            `pro_totalprice` decimal(10,2) DEFAULT NULL COMMENT '产品总金额',
//            `pro_status` int(255) DEFAULT NULL COMMENT '产品状态',
//            `pro_remark` varchar(255) DEFAULT NULL COMMENT '产品备注',
//            `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
//            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
//            `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
//            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
//            `remark` varchar(500) DEFAULT NULL COMMENT '备注',

}
