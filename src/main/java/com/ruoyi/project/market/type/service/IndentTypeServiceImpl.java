package com.ruoyi.project.market.type.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.market.indent.domain.Clientele;
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
    public Clientele selectByName() {

        return indentTypeMapper.selectByName();
    }


    public Clientele selectByTypeID(Integer dType) {

       return indentTypeMapper.selectByTypeID(dType);
    }
}
