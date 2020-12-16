package com.ruoyi.project.staff.message.mapper;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.staff.message.domain.Dep;
import com.ruoyi.project.staff.message.domain.Staff;
import com.ruoyi.project.staff.message.domain.StaffJob;
import com.ruoyi.project.staff.message.domain.vo.StaffVO;

import java.util.List;

public interface StaffMapper {

    List<StaffVO> selectStaffList(Staff staff);

    List<Dep> getDeps();

    List<StaffJob> getJobs();

    int addStaff(Staff staff);

    int checkSJobNumUnique(Staff staff);

    Staff selectStaffByJobNum(Long sId);

    int editStaff(Staff staff);

    List<Staff> getStaffByDepId(Long depId);

    int removeStaff(Long[] sJobNums);
}
