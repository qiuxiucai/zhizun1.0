package com.ruoyi.project.market.type.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.market.indent.domain.Clientele;
import com.ruoyi.project.market.indent.domain.Indent;
import com.ruoyi.project.market.type.domain.IndentVO;

import java.util.List;

public interface IIndentTypeService {

    List<IndentVO> selectIndentAll(Indent indent);

    List<Indent> selectIndent();

    Indent selectIndentName(Integer dId);

    Clientele selectByName();

}
