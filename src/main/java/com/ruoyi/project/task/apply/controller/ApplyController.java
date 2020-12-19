package com.ruoyi.project.task.apply.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.staff.message.domain.Dep;
import com.ruoyi.project.staff.message.domain.Staff;
import com.ruoyi.project.staff.message.service.IStaffService;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.service.IUserService;
import com.ruoyi.project.task.apply.domain.Apply;
import com.ruoyi.project.task.apply.domain.Approve;
import com.ruoyi.project.task.apply.service.IApplyService;
import com.ruoyi.project.task.taskbuild.domain.Task;
import com.ruoyi.project.task.taskbuild.service.ITaskBuildService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/task/apply")
@RequiresPermissions("task:apply:view")
public class ApplyController  extends BaseController {
    @Autowired
    private IApplyService applyService;
    @Autowired
    private IStaffService iStaffService;
    @Autowired
    private ITaskBuildService taskBuildService;
    @Autowired
    private IUserService userService;
    private String prefix = "task/apply";
    @RequiresPermissions("task:apply:view")
    @GetMapping()
    public String taskbuild() {
        return prefix + "/taskapply";
    }
    @ResponseBody
    @PostMapping("/list")
    @RequiresPermissions("task:apply:list")
    public TableDataInfo list(Apply apply){

        startPage();
        List<Apply> applys = applyService.selectApplyList(apply);
        return getDataTable(applys);
    }
    @GetMapping("/add")
    @RequiresPermissions("task:apply:add")
    public String add(Model model) {

        return prefix + "/add";
    }
    @PostMapping("/addApply")
    @ResponseBody
    public AjaxResult addTask(Apply apply , String eEndtime,Integer tText) throws ParseException {
        int  depId=Integer.parseInt(apply.getUDep());
        Dep depsById = iStaffService.getDepsById(depId);
        System.out.println("apply = " + apply);
        System.out.println("eEndtime = " + eEndtime);
        System.out.println("tText = " + tText);
        char del='T';
        String EndTime="";
        //2020-12-25T22:22
        for(int i=0;i<eEndtime.length();i++){
            if(eEndtime.charAt(i)!=del){
                EndTime+=eEndtime.charAt(i);
            }
        }
        String s1 = EndTime.substring(0, 10);
        String s2=  EndTime.substring(10,14);
        EndTime=s1+" "+s2;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//转换时区格式
        Date etime=sdf.parse(EndTime);
        System.out.println("etime = " + etime);
        Apply app = new Apply();
        app.setEId(null);
        app.setEHandletime(null);
        app.setTId(tText);
        app.setEStatus(0);
        app.setEReason(apply.getEReason());
        app.setUName(apply.getUName());
        app.setUDep(depsById.getDeptName());
        app.setEInfo(null);
        app.setEStarttime(LocalDate.now());
        app.setEEndtime(etime);
        return applyService.addApply(app);
    }
    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("task:apply:remove")
    public AjaxResult remove(Integer [] ids){
        System.out.println("ids = " + ids);
        String userName = getSysUser().getUserName();
        System.out.println("userName = " + userName);
        if(userName.equals("若依")){
            //写删除方法
        List<Task> task=taskBuildService.selectByIds(ids);
        System.out.println("task = " + task);
        for (int i=0;i<task.size();i++){
            if(task.get(i).getTStatus()==0){
                return AjaxResult.error("你选中的任务还有没完成的,不能删除!");
            }
        }
            return toAjax(applyService.deleteByIds(ids));
        }
       else{
            return AjaxResult.error("你没有权限删除此条数据");
        }
    }
    @GetMapping("/edit/{eId}")
    @RequiresPermissions("task:apply:edit")
    public String editTask(@PathVariable int eId, Model m,HttpSession session) {
         String userName = getLoginName();
         System.out.println("userName = " + userName);
         Apply app= applyService.selectUdepById(eId);
         String depName=app.getUDep();//前端页面传过来人名称
         User user=  userService.selectUserByLoginName(userName);
         Apply ap=applyService.selectUdepById(eId);
         Task tk=taskBuildService.selectTaskListById(eId);
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
         m.addAttribute("tStart",sdf.format(tk.getTStart()));
         m.addAttribute("tTend",sdf.format(tk.getTEnd()));
         m.addAttribute("eEndtime",sdf.format(ap.getEEndtime()));

         Approve approve = new Approve();
         approve.setEId(eId);
         approve.setTTitle(tk.getTTitle());
         approve.setTText(tk.getTText());
         approve.setUName(ap.getUName());
         approve.setTStart(tk.getTStart());
         approve.setTEnd(tk.getTEnd());
         approve.setEEndtime(ap.getEEndtime());
         approve.setEReason(ap.getEReason());
        m.addAttribute("approve",approve);
        if(user.getLoginName().equals("admin")){
             return prefix + "/edit";
         }
         else{
             int deptId =  user.getDeptId().intValue();
             System.out.println("deptId = " + deptId);
             Dep deps = iStaffService.getDepsById(deptId);
             System.out.println("deps = " + deps.getDeptName());
             System.out.println("depName = " + depName);
             if(deps.getDeptName().equals(depName)){
                 return prefix+"/edit";
             }
             else{
                 return prefix+"/unapprove";
             }
         }
    }
    @PostMapping("/applyEdit")
    @ResponseBody
    public AjaxResult applyEdit( Integer eId,Integer eStatus,String eInfo){

      System.out.println("eId = " + eId);
      Apply app= applyService.selectById(eId);
        Apply apply = new Apply();
        apply.setEId(eId);
        apply.setEReason(app.getEReason());
        apply.setEStarttime(app.getEStarttime());
        apply.setEEndtime(app.getEEndtime());
        apply.setEHandletime(LocalDate.now());
        apply.setEInfo(eInfo);
        apply.setUDep(app.getUDep());
        apply.setUName(app.getUName());
        apply.setEStatus(eStatus);
        apply.setTId(app.getTId());
        applyService.updateById(apply);

        return  applyService.updateById(apply);


    }




}
