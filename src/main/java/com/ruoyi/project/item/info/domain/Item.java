package com.ruoyi.project.item.info.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 项目表映射实体类
 * 17361 20:01
 */
@Data
public class Item {

    private Integer pId; //项目表主键
    private String pNum; //项目编号
    private String pTitle; //项目名称
    private String pText; //项目内容
    private Integer pTypeId; //项目类型数值
    private String pTypeName; //项目类型名称
    private Integer pStatuc; //项目状态值
    private String pStatusName; //项目状态名称
    private String pCreate; //项目创建人
    private Date pStart; //项目创建时间
    private Date pEnd; //项目结束时间
    private Integer pCid; //客户表外键
    private Long pTotal; //项目总金额
    private String pPeriod; //项目周期
    private Integer pDid; //订单类别
    private String pRemark; //项目备注

}
