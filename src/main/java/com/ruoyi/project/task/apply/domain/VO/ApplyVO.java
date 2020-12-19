package com.ruoyi.project.task.apply.domain.VO;

import com.ruoyi.project.task.apply.domain.Apply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyVO extends Apply {

private String tText;



}
