package com.ruoyi.project.market.indent.domain;

import lombok.Data;

@Data
public class Indent extends Clientele{
    //订单主键
    private Integer dId;
    //订单类别
    private Integer dType;
    //订单类型名称
    private String dName;
    //订单编号
    private String dNum;
    //订单数量
    private Long dAmount;
    //订单备注
    private String dRemark;
    //产品编号
    private String gNum;
    //客户Id
    private Integer cId;


}
