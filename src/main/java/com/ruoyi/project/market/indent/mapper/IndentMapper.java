package com.ruoyi.project.market.indent.mapper;

import com.ruoyi.project.market.indent.domain.IndentAllVO;

import java.util.List;

public interface IndentMapper {
    List<IndentAllVO> selectAll(IndentAllVO indentAllVO);
}
