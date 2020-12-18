package com.ruoyi.project.staff.message.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.staff.message.domain.Dep;
import com.ruoyi.project.staff.message.domain.Staff;
import com.ruoyi.project.staff.message.domain.StaffJob;
import com.ruoyi.project.staff.message.domain.vo.StaffVO;

import java.util.List;

public interface IStaffService {

    List<StaffVO> selectStaffList(Staff staff);

    List<Dep> getDeps();

    List<StaffJob> getJobs();

    AjaxResult addStaff(Staff staff);

    String checkSJobNumUnique(Staff staff);

    Staff selectStaffByJobNum(Long jId);

    AjaxResult editStaff(Staff staff);

    List<Staff> getStaffByDepId(Long depId);

    Dep getDepsById(int depId);

    List<Staff> selectNameList();


    Dep selectByName(String depName);
}
