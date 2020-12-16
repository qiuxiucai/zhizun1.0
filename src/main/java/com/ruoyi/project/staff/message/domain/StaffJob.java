package com.ruoyi.project.staff.message.domain;

import lombok.Data;

@Data
public class StaffJob {

    /**
     * 职位编号 primary key
     */
    private Integer jId;

    /**
     * 职位名称
     */
    private String jName;

    /**
     * 职位等级 1:经理 , 2:员工
     */
    private Integer jGra;

    /**
     * 上级职位
     */
    private Integer jSup;
}
