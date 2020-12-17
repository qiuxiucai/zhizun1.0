package com.ruoyi.project.market.indent.service;

import com.ruoyi.project.market.indent.domain.IndentAllVO;
import com.ruoyi.project.market.indent.mapper.IndentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndentServiceImpl implements IIndentService {
    @Autowired
    private IndentMapper indentMapper;

    @Override
    public List<IndentAllVO> selectAll() {
        return indentMapper.selectAll();
    }

    @Override
    public IndentAllVO selectByNum(Integer pid) {
        return indentMapper.selectByNum(pid);
    }


}
