package com.ruoyi.project.staff.message.service;

import com.ruoyi.project.staff.message.domain.Staff;
import com.ruoyi.project.staff.message.domain.vo.StaffVO;
import com.ruoyi.project.staff.message.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStaffServiceImpl implements IStaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<StaffVO> selectStaffList(Staff staff) {

        return staffMapper.selectStaffList(staff);
    }
}
