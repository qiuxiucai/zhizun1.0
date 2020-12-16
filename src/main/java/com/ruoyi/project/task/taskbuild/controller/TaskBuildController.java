package com.ruoyi.project.task.taskbuild.controller;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;

import com.ruoyi.project.cms.content.domain.Content;
import com.ruoyi.project.cms.type.domain.CmsType;
import com.ruoyi.project.cms.type.domain.CmsTypeVo;
import com.ruoyi.project.task.taskbuild.domain.Task;
import com.ruoyi.project.task.taskbuild.service.ITaskBuildService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/task/build")

public class TaskBuildController extends BaseController {

    private String prefix = "task/build";

    @Autowired
    private ITaskBuildService iTaskBuildService;

    @RequiresPermissions("task:build:view")
    @GetMapping()
    public String taskbuild() {
        return prefix + "/taskbuild";
    }


    @ResponseBody
    @PostMapping("/list")
    @RequiresPermissions("task:build:list")
    public TableDataInfo list(Task task){

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
    public String add(Model model) {



        return prefix + "/add";
    }





}
