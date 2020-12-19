package com.ruoyi.project.task.taskbuild.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Excel(name="任务编号")
    private Integer tId;
    @Excel(name = "任务标题")
    private String tTitle;
    @Excel(name="任务内容")
    private String tText;
    @Excel(name="任务开始时间")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "任务结束时间")
    private Date tEnd;
    @Excel(name="任务负责部门")
    private String depName;
    @Excel(name = "任务负责人")
    private String sName;
    private Integer tStatus;
    private String tAnnex;
    private Integer tComplete;
}
