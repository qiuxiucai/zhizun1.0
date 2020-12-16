package com.ruoyi.project.staff.message.domain.vo;

import com.ruoyi.project.staff.message.domain.Staff;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wuxx
 * 2020年12月16日10:33:59
 * 展示页面的数据类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StaffVO extends Staff {

    private String deptName;

    private String jobName;

}
