package com.ruoyi.project.market.type.mapper;

import com.ruoyi.project.market.indent.domain.Clientele;
import com.ruoyi.project.market.indent.domain.Indent;
import com.ruoyi.project.market.type.domain.IndentVO;

import java.util.List;

public interface IndentTypeMapper {
    List<IndentVO> selectIndentAll(Indent indent);

    List<Indent> selectIndent();

    Indent selectIndentName(Integer dId);


    Clientele selectByName();

}
