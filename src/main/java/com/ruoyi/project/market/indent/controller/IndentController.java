package com.ruoyi.project.market.indent.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.market.indent.domain.IndentAllVO;
import com.ruoyi.project.market.indent.service.IIndentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/market/indent")
public class IndentController extends BaseController {

    private String prefix = "market/indent";
    private IIndentService indentService;
    @RequiresPermissions("market:indent :view")
    @GetMapping()
    public String operlog() {
        return prefix + "/indent";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(IndentAllVO indentAllVO) {
        startPage();
       List<IndentAllVO> indentAllVOS= indentService.selectAll(indentAllVO);

        return  getDataTable(indentAllVOS);
    }

}
