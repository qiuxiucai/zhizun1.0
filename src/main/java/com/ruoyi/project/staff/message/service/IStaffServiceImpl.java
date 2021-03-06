package com.ruoyi.project.staff.message.service;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.staff.message.domain.Dep;
import com.ruoyi.project.staff.message.domain.Staff;
import com.ruoyi.project.staff.message.domain.StaffDetail;
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
    public AjaxResult removeStaff(Long[] sJobNums) {
        int i = staffMapper.removeStaff(sJobNums);
        if (i == sJobNums.length){
            return AjaxResult.success("成功删除" + i + "条数据");
        }
        return AjaxResult.error("删除失败");
    }

    @Override
    public StaffDetail selectStaffDetailByJobNum(Integer sJobNum) {
        return staffMapper.selectStaffDetailByJobNum(sJobNum);
    }

    @Override
    public Dep getDepsById(int depId) {
        return staffMapper.getDepsById(depId);
    }

    @Override
    public Dep selectByName(String depName) {
        return staffMapper.selectByName(depName);
    }


    @Override
    public Integer checkSJobNumUnique(Staff staff) {

        return staffMapper.checkSJobNumUnique(staff);
    }

    public List<Staff> selectAll(){
        return staffMapper.selectAll();
    }


    @Override
    public Staff selectStaffByJobNum(Long jId) {

        return staffMapper.selectStaffByJobNum(jId);
    }
}
