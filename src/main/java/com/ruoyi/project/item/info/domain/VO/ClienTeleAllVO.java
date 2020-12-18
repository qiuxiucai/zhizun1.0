package com.ruoyi.project.item.info.domain.VO;

import lombok.Data;

/**
 * 17361 20:23
 */
@Data
public class ClienTeleAllVO {
    //客户主键
    private  Integer cId;
    //客户名称
    private  String cName;
    //客户联系方式
    private  String cPhone;
    //客户备注信息
    private  String cRemark;
    //客户公司名称
    private  String cCompany;
    //客户类型
    private  String cType;

    private  Integer dType;
    //类型外键 1临时订单 2vip 订单 3普通订单

    private Integer TypeId;
    private String TypeName;

//  `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户主键id',
//  `c_name` varchar(255) NOT NULL COMMENT '客户姓名',
//  `c_phone` varchar(255) NOT NULL COMMENT '客户联系方式',
//  `c_remark` text COMMENT '客户备注信息',
//  `c_company` varchar(255) DEFAULT NULL COMMENT '客户公司名称',
//  `c_type` varchar(255) DEFAULT NULL COMMENT '客户类型，vipand普通客户',
//  `d_type` int(255) DEFAULT NULL COMMENT '1 临时订单 2vip订单 3普通订单',
//  `type_id`

}
