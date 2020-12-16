package com.ruoyi.project.staff.message.mapper;

import com.ruoyi.project.staff.message.domain.Staff;
import com.ruoyi.project.staff.message.domain.vo.StaffVO;

import java.util.List;

public interface StaffMapper {

    List<StaffVO> selectStaffList(Staff staff);
}
