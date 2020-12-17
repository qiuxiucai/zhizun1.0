package com.ruoyi.project.task.taskbuild.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.task.taskbuild.domain.Level;
import com.ruoyi.project.task.taskbuild.domain.Task;


import com.ruoyi.project.task.taskbuild.mapper.TaskBuildMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("task")
public class ITaskBuildServiceImpl implements ITaskBuildService{

    @Autowired
    private com.ruoyi.project.task.taskbuild.mapper.TaskBuildMapper TaskBuildMapper;
    @Override
    public List<Task> selectTaskList(Task task) {

        return TaskBuildMapper.selectTaskList(task);
    }

    @Override
    public List<Level> selectLevel() {
        return TaskBuildMapper.selectLevel() ;
    }

    @Override
    public int deleteTaskByIds(Integer[] ids) {
        return TaskBuildMapper.deleteTaskByIds(ids);
    }
    @Override
    public AjaxResult addTask(Task task) {
        int row = TaskBuildMapper.addTask(task);
        if(row==1){
               return AjaxResult.success("添加任务成功");
        }
           else {
               return AjaxResult.error("添加任务失败");
        }
    }

    @Override
    public Task selectTaskListById(int tId){


        return TaskBuildMapper.selectTaskListById(tId);
    }
}
