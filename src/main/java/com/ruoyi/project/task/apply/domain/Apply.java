package com.ruoyi.project.task.apply.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apply {

    private Integer eId;
    private Integer tId;
    private LocalDate eStarttime;
    private String eReason;
    private Integer eStatus;
    private String uName;
    private LocalDate eHandletime;
    private String eInfo;
    private String uDep;
    private Date eEndtime;




}
