package com.ruoyi.project.market.type.service;

import com.ruoyi.project.market.indent.domain.Indent;
import com.ruoyi.project.market.type.mapper.IndentTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("indentType")
public class IndentTypeServiceImpl implements IIndentTypeService {

    @Autowired
    private IndentTypeMapper indentTypeMapper;

    @Override
    public List<Indent> selectIndentAll(Indent indent) {

       List<Indent> indents= indentTypeMapper.selectIndentAll(indent);

        return indents;
    }

    @Override
    public List<Indent> selectIndent() {

        List<Indent> indents= indentTypeMapper.selectIndent();
        return indents;
    }
}
