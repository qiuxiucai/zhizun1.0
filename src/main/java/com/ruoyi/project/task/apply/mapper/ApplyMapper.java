package com.ruoyi.project.task.apply.mapper;

import com.ruoyi.project.task.apply.domain.Apply;
import com.ruoyi.project.task.taskbuild.domain.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ApplyMapper {

    List<Apply> selectApplyList(Apply apply);

    int addApply(Apply app);

    int deleteByIds(Integer[] ids);

    Apply selectUdepById(int eId);

    Apply selectById(Integer eId);

    int updateById(Apply apply);
}
