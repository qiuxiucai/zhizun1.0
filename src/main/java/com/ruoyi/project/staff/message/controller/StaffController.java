package com.ruoyi.project.staff.message.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.staff.message.domain.Staff;
import com.ruoyi.project.staff.message.domain.StaffDetail;
import com.ruoyi.project.staff.message.domain.vo.StaffVO;
import com.ruoyi.project.staff.message.service.IStaffService;
import com.ruoyi.project.system.post.domain.Post;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wuxx
 * 2020年12月16日10:00:17
 */
@RequestMapping("/staff/message")
@Controller
public class StaffController extends BaseController {

    //配置前缀
    private String prefix = "staff/message";

    @Autowired
    private IStaffService iStaffService;

    /**
     * @return 返回跳转地址
     */
    @RequiresPermissions("staff:message:view")
    @GetMapping()
    public String staff(){
        return prefix + "/message";
    }

    /**
     * 通过条件查询员工的信息
     * @param staff 条件
     * @return 返回分页数据
     */
    @RequiresPermissions("staff:message:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo staff(Staff staff){

        System.out.println(staff);

        //开始分页
        startPage();
        List<StaffVO> list = iStaffService.selectStaffList(staff);
        for (StaffVO staffVO : list) {
            System.out.println(staffVO.getDepId());
        }
        //返回封装后的数据
        return getDataTable(list);
    }

    /**
     * 跳转到添加页面
     * @return 返回添加页面路径
     */
    @RequiresPermissions("staff:message:add")
    @GetMapping("/add")
    public String addStaff(){
        return prefix + "/add";
    }

    /**
     * 添加用户
     * @param staff (经过数据填充)表单上传的员工属性
     * @return 返回json格式信息
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addStaff(Staff staff){
        return iStaffService.addStaff(staff);
    }

    /**
     * 跳转到修改员工属性页面
     * @return 返回修改路径
     */
    @RequiresPermissions("staff:message:edit")
    @GetMapping("/edit/{sId}")
    public String editStaff(@PathVariable("sId") Long jId, Model model){
        Staff staff = iStaffService.selectStaffByJobNum(jId);
        model.addAttribute("staff",staff);
        return prefix + "/edit";
    }

    /**
     * 修改员工属性
     * @param staff 修改后的员工属性
     * @return 返回json格式信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editStaff(Staff staff){
        return iStaffService.editStaff(staff);
    }

    @RequestMapping("/remove")
    @RequiresPermissions("staff:message:remove")
    @ResponseBody
    public AjaxResult removeStaff(Long[] ids){
        return iStaffService.removeStaff(ids);
    }

    @RequestMapping("/detail/{sJobNum}")
    public String staffDetail(@PathVariable("sJobNum") Integer sJobNum,Model model){
        StaffDetail staff = iStaffService.selectStaffDetailByJobNum(sJobNum);
        model.addAttribute("staff",staff);
        return prefix + "/detail";
    }

    /**
     * 校验工号
     */
    @PostMapping("/checkSJobNumUnique")
    @ResponseBody
    public Integer checkSJobNumUnique(Staff staff) {
        Integer i = iStaffService.checkSJobNumUnique(staff);
        return i;
    }
}
