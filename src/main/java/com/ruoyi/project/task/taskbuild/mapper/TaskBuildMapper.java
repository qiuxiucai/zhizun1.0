package com.ruoyi.project.task.taskbuild.mapper;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.task.taskbuild.domain.Level;
import com.ruoyi.project.task.taskbuild.domain.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TaskBuildMapper {
    List<Task> selectTaskList(Task task);
    List<Level>  selectLevel();
    int deleteTaskByIds(Integer[] ids);

    int addTask(Task task);

    Task selectTaskListById(int tId);
}
