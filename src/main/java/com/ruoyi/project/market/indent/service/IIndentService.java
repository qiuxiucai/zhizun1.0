package com.ruoyi.project.market.indent.service;

import com.ruoyi.project.market.indent.domain.IndentAllVO;

import java.util.List;

public interface IIndentService {
    List<IndentAllVO> selectAll();

    IndentAllVO selectByNum(Integer pid);
}
