package com.ruoyi.project.market.type.mapper;

import com.ruoyi.project.market.indent.domain.Indent;

import java.util.List;

public interface IndentTypeMapper {
    List<Indent> selectIndentAll(Indent indent);

    List<Indent> selectIndent();
}
