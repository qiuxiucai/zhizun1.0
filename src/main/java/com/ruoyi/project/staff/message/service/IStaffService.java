package com.ruoyi.project.staff.message.service;

import com.ruoyi.project.staff.message.domain.Staff;
import com.ruoyi.project.staff.message.domain.vo.StaffVO;

import java.util.List;

public interface IStaffService {

    List<StaffVO> selectStaffList(Staff staff);
}
