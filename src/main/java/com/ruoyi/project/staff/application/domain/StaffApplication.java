package com.ruoyi.project.staff.application.domain;

import lombok.Data;

/**
 * @author wuxx
 */
@Data
public class StaffApplication {

    /**
     * 申请表主键
     *
     */
    private Integer aId;

    /**
     * 申请表标题
     */
    private String aTitle;

    /**
     * 员工工号
     */
    private Integer sJobNum;

    /**
     * 申请状态 0 是审核中 1 是审核成功
     */
    private Integer aStatus;
}
