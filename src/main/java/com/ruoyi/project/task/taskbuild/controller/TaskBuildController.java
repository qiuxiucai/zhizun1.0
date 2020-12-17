package com.ruoyi.project.task.taskbuild.controller;


import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;

import com.ruoyi.project.staff.message.domain.Dep;
import com.ruoyi.project.staff.message.domain.Staff;
import com.ruoyi.project.staff.message.service.IStaffService;

import com.ruoyi.project.task.taskbuild.domain.Task;
import com.ruoyi.project.task.taskbuild.service.ITaskBuildService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/task/build")

public class TaskBuildController extends BaseController {

    private String prefix = "task/create";

    @Autowired
    private ITaskBuildService iTaskBuildService;

  @Autowired
  private IStaffService iStaffService;

    @RequiresPermissions("task:build:view")
    @GetMapping()
    public String taskbuild() {
        return prefix + "/taskbuild";
    }


    @ResponseBody
    @PostMapping("/list")
    @RequiresPermissions("task:build:list")
    public TableDataInfo list(Task task){
        System.out.println("task = " + task);
        startPage();
        List<Task> tasks = iTaskBuildService.selectTaskList(task);
        return getDataTable(tasks);
    }


    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("task:build:remove")
    public AjaxResult remove(Integer [] ids){
        System.out.println("ids = " + ids);
        return toAjax(iTaskBuildService.deleteTaskByIds(ids));
    }


    @GetMapping("/add")
    @RequiresPermissions("task:build:add")
    public String add(Model model) {



        return prefix + "/add";
    }


    @GetMapping("/depList")
    @ResponseBody
    public List<Dep> depList(){
        List<Dep> deps = iStaffService.getDeps();
        return deps;
    }

    @GetMapping("/sNameList")
    @ResponseBody
    public List<Staff> sNameList(Long sName){
        List<Staff> staff = iStaffService.getStaffByDepId(sName);
        return staff;
    }
    @PostMapping("/addTask")
    @ResponseBody
    public AjaxResult addTask(Task task ,String tStart,String tEnd) throws ParseException {
         int depId= (Integer.parseInt(task.getDepName()));
         Dep dep = iStaffService.getDepsById(depId);
         char del='T';
         String tStartTime="";
         String tEndTime="";
         //2020-12-25T22:22
         for(int i=0;i<tStart.length();i++){
             if(tStart.charAt(i)!=del){
              tStartTime+=tStart.charAt(i);
             }
         }
         String s1 = tStartTime.substring(0, 10);
         String s2=  tStartTime.substring(10,14);
         tStartTime=s1+" "+s2;
        for(int j=0;j<tEnd.length();j++){
            if(tEnd.charAt(j)!=del){
                tEndTime+=tEnd.charAt(j);
            }
        }
        String s3=tEndTime.substring(0,10);
        String s4=tEndTime.substring(10,14);
        tEndTime=s3+" "+s4;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//转换时区格式
        Date tStartTimes=sdf.parse(tStartTime);
        Date tEndTimes=sdf.parse(tEndTime);
        String depName=dep.getDeptName();
        Task task1 = new Task();
        task1.setTId(null);
        task1.setSName(task.getSName());
        task1.setDepName(depName);
        task1.setTStart(tStartTimes);
        task1.setTEnd(tEndTimes);
        task1.setTTitle(task.getTTitle());
        task1.setTText(task.getTText());
        task1.setTStatus(task.getTStatus());
        task1.setTAnnex(null);
        task1.setTComplete(task.getTComplete());
        return iTaskBuildService.addTask(task1);
    }

    @GetMapping("/edit/{tId}")
    @RequiresPermissions("task:build:edit")
    public String editTask(@PathVariable int tId, Model m) {
        System.out.println("修改任务");
        System.out.println("tId = " + tId);
        Task task = iTaskBuildService.selectTaskListById(tId);
        m.addAttribute("taskEdit",task);
        return prefix + "/edit";
    }


}
