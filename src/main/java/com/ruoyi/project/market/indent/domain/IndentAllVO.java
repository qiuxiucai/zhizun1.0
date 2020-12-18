package com.ruoyi.project.market.indent.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.project.item.info.domain.Item;
import com.ruoyi.project.staff.message.domain.Staff;
import lombok.Data;

import java.util.Date;

@Data
public class IndentAllVO {


    /**
     * 员工主键
     */
    private Long sId;

    /**
     * 员工编号
     */
    private Long sJobNum;

    /**
     * 员工姓名
     */
    private String sName;

    /**
     * 职位表外键
     */
    private Integer jId;

    /**
     * 员工手机号
     */
    private String sPhone;

    /**
     * 部门表主键
     */
    private Integer depId;

    /**
     * 入职时间
     */
    private Date sDate;

    /**
     * 员工状态 0 代表离职, 1 代表正常
     */
    private Integer sStatus;

    private Integer pId; //项目表主键
    private String pNum; //项目编号
    private String pTitle; //项目名称
    private String pText; //项目内容
    private Integer pTypeId; //项目类型数值
    private String pTypeName; //项目类型名称
    private Integer pStatuc; //项目状态值
    private String pStatusName; //项目状态名称
    private String pCreate; //项目创建人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pStart; //项目创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pEnd; //项目结束时间
    private Integer pCid; //客户表外键
    private Long pTotal; //项目总金额
    private String pPeriod; //项目周期
    private Integer pDid; //订单类别
    private String pRemark; //项目备注
    private Integer pSid;
    private String pStyle;
    private Integer pProId;


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
