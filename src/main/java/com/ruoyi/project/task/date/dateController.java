package com.ruoyi.project.task.date;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.task.taskbuild.domain.Task;
import com.ruoyi.project.task.taskbuild.service.ITaskBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/task/date")
public class dateController extends BaseController {

    private String prefix = "task/date";
    @Autowired
    private ITaskBuildService iTaskBuildService;

    @GetMapping("query")
    public String dateList(){

     return prefix+"/date";
    }
@PostMapping("/selectTask")
@ResponseBody
public List<Task> selectTask(String  date) throws ParseException {

    System.out.println("date = " + date);
    String s1 = date.substring(0, 10);
    String endtime=s1+" "+"23:59:59";
    List<Task> task= iTaskBuildService.slectByDate(date,endtime);
    return task;
}


}
