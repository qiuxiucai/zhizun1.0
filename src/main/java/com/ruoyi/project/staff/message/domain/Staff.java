package com.ruoyi.project.staff.message.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Staff {

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

}
