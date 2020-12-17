package com.ruoyi.project.market.indent.domain;

import com.ruoyi.project.product.details.domain.Goods;
import lombok.Data;

/**
 *
 *
 *
 *
 */
@Data
public class Clientele extends Goods {

    private  Integer cId;
    private  String cName;
    private  String cPhone;
    private  String cRemark;
    private  String cCompany;
    private  String cType;
    private  Integer dType;

//      `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户主键id',
//            `c_name` varchar(255) NOT NULL COMMENT '客户姓名',
//            `c_phone` varchar(255) NOT NULL COMMENT '客户联系方式',
//            `c_remark` text COMMENT '客户备注信息',
//            `c_company` varchar(255) DEFAULT NULL COMMENT '客户公司名称',
//            `c_type` varchar(255) DEFAULT NULL COMMENT '客户类型，vipand普通客户',
//            `d_type` int(255) DEFAULT NULL COMMENT '1 临时订单 2vip订单 3普通订单

}
