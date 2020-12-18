package com.ruoyi.project.market.type.service;

import com.ruoyi.project.market.indent.domain.Indent;

import java.util.List;

public interface IIndentTypeService {

    List<Indent> selectIndentAll(Indent indent);

    List<Indent> selectIndent();
}
