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
    //类型外键 1临时订单 2vip 订单 3普通订单
    private  Integer dType;

}
