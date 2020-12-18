package com.ruoyi.project.staff.message.service;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.staff.message.domain.Dep;
import com.ruoyi.project.staff.message.domain.Staff;
import com.ruoyi.project.staff.message.domain.StaffJob;
import com.ruoyi.project.staff.message.domain.vo.StaffVO;
import com.ruoyi.project.staff.message.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("staffService")
public class IStaffServiceImpl implements IStaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<StaffVO> selectStaffList(Staff staff) {

        return staffMapper.selectStaffList(staff);
    }

    /**
     * @return 获取所有的部门信息
     */
    @Override
    public List<Dep> getDeps() {
        return staffMapper.getDeps();
    }

    @Override
    public List<StaffJob> getJobs() {
        return staffMapper.getJobs();
    }

    @Override
    public AjaxResult addStaff(Staff staff) {

        int i = staffMapper.addStaff(staff);
        if (i > 0){
            return AjaxResult.success("添加员工成功");
        }
        return AjaxResult.error("添加员工失败");
    }

    @Override
    public AjaxResult editStaff(Staff staff) {
        int i = staffMapper.editStaff(staff);
        if (i > 0){
            return AjaxResult.success("修改员工成功");
        }
        return AjaxResult.error("修改员工失败");
    }

    @Override
    public List<Staff> getStaffByDepId(Long depId) {
        return staffMapper.getStaffByDepId(depId);
    }

    @Override
    public Dep getDepsById(int depId) {


        return staffMapper.selectDepById(depId);
    }

    @Override
    public List<Staff> selectNameList() {




        return staffMapper.selectNameList();
    }

    @Override
    public Dep selectByName(String depName) {
        return staffMapper.selectStaffByName(depName);
    }


    @Override
    public String checkSJobNumUnique(Staff staff) {

        return String.valueOf(staffMapper.checkSJobNumUnique(staff));
    }

    @Override
    public Staff selectStaffByJobNum(Long jId) {

        return staffMapper.selectStaffByJobNum(jId);
    }




}
