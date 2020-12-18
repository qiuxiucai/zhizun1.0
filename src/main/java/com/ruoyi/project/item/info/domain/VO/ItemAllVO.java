package com.ruoyi.project.item.info.domain.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 17361 10:33
 */
@Data
public class ItemAllVO {
    private Integer pId; //项目表主键
    @Excel(name = "项目名称")
    private String pTitle; //项目名称 1  普通修改
    @Excel(name = "订单编号")
    private String pNum; //项目编号 1
    @Excel(name = "项目负责人")
    private String sName; //项目负责人 1  下拉框选择
    @Excel(name = "项目总金额")
    private Long pTotal; //项目总金额  1  普通修改
    @Excel(name = "项目周期")
    private String pPeriod; //项目周期 1 普通修改
    @Excel(name = "订单类别")
    private String dName; //订单类别  1  下拉框修改
    @Excel(name = "客户编号")
    private Integer pCid; //客户表外键  1
    @Excel(name = "客户名称")
    private  String cName; //客户名称  1  下拉框修改 实际提交pCid
    @Excel(name = "客户类型")
    private String TypeName; //客户类型  下拉框修改
//    @Excel(name = "客户类型")
//    private  String cType;  //客户类型 1
    @Excel(name = "客户公司名称")
    private  String cCompany;  //客户公司名称 1  普通修改
    @Excel(name = "联系方式")
    private  String cPhone;  //联系方式 1  普通修改
    @Excel(name = "客户备注信息")
    private  String cRemark;  //客户备注信息 1  普通修改
    @Excel(name = "项目内容")
    private String pText; //项目内容 1  普通修改
    @Excel(name = "项目风格")
    private String pStyle; //项目风格 1  普通修改
    @Excel(name = "项目类型名称")
    private String pTypeName; //项目类型名称  1  普通修改
    @Excel(name = "项目订立时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pStart; //项目创建时间  1 日历修改
    @Excel(name = "项目完成时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pEnd; //项目结束时间 1  日历时间修改
    @Excel(name = "项目备注")
    private String pRemark; //项目备注 1  普通文本修改
    @Excel(name = "产品型号")
    private String productModel;  //产品型号(编号)1  下拉框修改产品id
    @Excel(name = "产品名称")
    private String productName;  //产品名称1
    @Excel(name = "订单产品数量")
    private Integer dAmount; //订单产品数量  1 普通修改
    @Excel(name = "产品单价")
    private Integer productPrice; //产品单价1
    @Excel(name = "订单总价")
    private Integer TotalPrice;
    @Excel(name = "产品备注")
    private String productRemark; //添加产品备注1



    private String pStatusName; //项目状态名称 1

}