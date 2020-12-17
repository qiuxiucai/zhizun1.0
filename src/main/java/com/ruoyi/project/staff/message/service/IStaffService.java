package com.ruoyi.project.staff.message.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.staff.message.domain.Dep;
import com.ruoyi.project.staff.message.domain.Staff;
import com.ruoyi.project.staff.message.domain.StaffDetail;
import com.ruoyi.project.staff.message.domain.StaffJob;
import com.ruoyi.project.staff.message.domain.vo.StaffVO;

import java.util.List;

public interface IStaffService {

    /**
     * 查询所有员工包括封装后的部门信息和工作信息
     */
    List<StaffVO> selectStaffList(Staff staff);

    /**
     * 查询所有部门
     */
    List<Dep> getDeps();

    /**
     * 查询所有工作
     */
    List<StaffJob> getJobs();

    /**
     * 添加员工
     */
    AjaxResult addStaff(Staff staff);

    /**
     * 工号的查询唯一
     */
    Integer checkSJobNumUnique(Staff staff);

    /**
     * 根据工号查询员工
     */
    Staff selectStaffByJobNum(Long jId);

    /**
     * 修改员工属性
     */
    AjaxResult editStaff(Staff staff);

    /**
     * 根据部门编号查询所属部门的员工
     */
    List<Staff> getStaffByDepId(Long depId);

    AjaxResult removeStaff(Long[] sJobNums);

    StaffDetail selectStaffDetailByJobNum(Integer sJobNum);
}
