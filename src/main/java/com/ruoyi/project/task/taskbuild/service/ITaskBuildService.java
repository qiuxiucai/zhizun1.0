package com.ruoyi.project.task.taskbuild.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.task.taskbuild.domain.Level;
import com.ruoyi.project.task.taskbuild.domain.Task;

import java.util.List;

public interface ITaskBuildService {


  public   List<Task> selectTaskList(Task task);

  public  List<Level> selectLevel();


  int deleteTaskByIds(Integer[] ids);

    AjaxResult addTask(Task task);

    Task selectTaskListById(int tId);

    AjaxResult updateTask(Task task);
}
