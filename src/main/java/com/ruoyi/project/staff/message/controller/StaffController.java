package com.ruoyi.project.staff.message.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.staff.message.domain.Staff;
import com.ruoyi.project.staff.message.domain.vo.StaffVO;
import com.ruoyi.project.staff.message.service.IStaffService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private IStaffService IStaffService;

    /**
     * @return 返回跳转地址
     */
    @RequiresPermissions("staff:message:view")
    @GetMapping
    public String staff(){
        return prefix + "/message";
    }

    /**
     * 通过条件查询员工的信息
     * @param staff 条件
     * @return 返回分页数据
     */
    @RequiresPermissions("staff:message:list")
    @RequestMapping("/list")
    @ResponseBody
    public TableDataInfo staff(Staff staff){
        //开始分页
        startPage();
        List<StaffVO> list = IStaffService.selectStaffList(staff);
        for (StaffVO staffVO : list) {
            System.out.println(staffVO.getDepId());
        }
        //返回封装后的数据
        return getDataTable(list);
    }

}
