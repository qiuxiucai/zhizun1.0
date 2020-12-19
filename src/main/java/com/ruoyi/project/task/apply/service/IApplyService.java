package com.ruoyi.project.task.apply.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.task.apply.domain.Apply;

import java.util.List;

public interface IApplyService {



    List<Apply> selectApplyList(Apply apply);

    AjaxResult addApply(Apply app);

    int deleteByIds(Integer[] ids);

    Apply selectUdepById(int eId);

    Apply selectById(Integer eId);

    AjaxResult updateById(Apply apply);
}
