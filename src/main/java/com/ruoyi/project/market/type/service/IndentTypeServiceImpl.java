package com.ruoyi.project.market.type.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.market.indent.domain.Indent;
import com.ruoyi.project.market.type.domain.IndentVO;
import com.ruoyi.project.market.type.mapper.IndentTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("indentType")
public class IndentTypeServiceImpl implements IIndentTypeService {

    @Autowired
    private IndentTypeMapper indentTypeMapper;

    @Override
    public List<IndentVO> selectIndentAll(Indent indent) {

       List<IndentVO> indents= indentTypeMapper.selectIndentAll(indent);

        return indents;
    }

    @Override
    public List<Indent> selectIndent() {

        List<Indent> indents= indentTypeMapper.selectIndent();
        return indents;
    }

    @Override
    public Indent selectIndentName(Integer dId) {
        return indentTypeMapper.selectIndentName(dId);
    }

    @Override
    public AjaxResult updateNotice(Indent indent) {
        if (indent.getDType() == 1){
            indent.setDName("临时订单");
        }else if (indent.getDType() == 2){
            indent.setDName("vip订单");
        }else {
            indent.setDName("普通订单");
        }

       int a= indentTypeMapper.updateIndent(indent);
       if (a>0){
           return AjaxResult.success("订单分类类型修改成功");
       }
        return AjaxResult.error("订单类型修改失败");
    }


}
