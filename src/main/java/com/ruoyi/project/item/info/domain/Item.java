package com.ruoyi.project.item.info.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.market.indent.domain.Clientele;
import lombok.Data;

import java.util.Date;

/**
 * 项目表映射实体类
 * 17361 20:01
 */
@Data
public class Item extends Clientele {


    private Integer pId; //项目表主键
    private String pNum; //项目编号
    private String pTitle; //项目名称
    private String pText; //项目内容
    private Integer pTypeId; //项目类型数值
    private String pTypeName; //项目类型名称
    private Integer pStatuc; //项目状态值
    private String pStatusName; //项目状态名称
    private String pCreate; //项目创建人
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date pStart; //项目创建时间
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date pEnd; //项目结束时间
    private Integer pCid; //客户表外键
    private Long pTotal; //项目总金额
    private String pPeriod; //项目周期
    private Integer pDid; //订单类别
    private String pRemark; //项目备注
    private Integer pSid;
    private String pStyle;
    private Integer pProId;



    //      `i_id` int(11) NOT NULL COMMENT '项目表主键',
//            `i_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '项目编号',
//            `i_title` varchar(255) DEFAULT NULL COMMENT '项目名称',
//            `i_text` varchar(255) DEFAULT NULL COMMENT '项目内容',
//            `i_typeid` int(11) DEFAULT NULL COMMENT '项目类型值',
//            `i_typename` varchar(255) DEFAULT NULL COMMENT '项目类型名称',
//            `i_status` int(11) DEFAULT NULL COMMENT '项目状态值',
//            `i_statusname` varchar(255) DEFAULT NULL COMMENT '项目状态名称',
//            `i_create` varchar(255) DEFAULT NULL COMMENT '创建人',
//            `i_start` datetime DEFAULT NULL COMMENT '项目创建时间',
//            `i_end` datetime DEFAULT NULL COMMENT '项目结束时间',
//            `c_id` int(11) DEFAULT NULL COMMENT '客户表外键',
//            `i_total` bigint(20) DEFAULT NULL COMMENT '项目总金额',
//            `i_period` varchar(255) DEFAULT NULL COMMENT '项目周期',
//            `d_did` int(11) DEFAULT NULL COMMENT '订单类别',
//            `i_remark` text COMMENT '项目备注',
//            `s_id` int(255) DEFAULT NULL COMMENT '员工表外键',

}
