package com.ruoyi.project.task.apply.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.task.apply.domain.Apply;
import com.ruoyi.project.task.apply.mapper.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("apply")
public class IApplyServiceImpl implements IApplyService{

    @Autowired
    private ApplyMapper applyMapper;
    @Override
    public List<Apply> selectApplyList(Apply apply) {



        return applyMapper.selectApplyList(apply);
    }

    @Override
    public AjaxResult addApply(Apply app) {

       int row= applyMapper.addApply(app);
        if(row==1){

            return AjaxResult.success("添加成功");
        }

        else{

            return AjaxResult.error("添加失败");
        }

    }

    @Override
    public int deleteByIds(Integer[] ids) {
        return applyMapper.deleteByIds(ids);
    }

    @Override
    public Apply selectUdepById(int eId) {
        return applyMapper.selectUdepById(eId);
    }

    @Override
    public Apply selectById(Integer eId) {
        return applyMapper.selectById(eId);
    }

    @Override
    public AjaxResult updateById(Apply apply) {
        int row=applyMapper.updateById(apply);
        if(row==1){
            return AjaxResult.success("审批成功");
        }
        else{
            return AjaxResult.error("审批失败");
        }

    }
}
