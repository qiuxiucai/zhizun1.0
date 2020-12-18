package com.ruoyi.project.market.type.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.market.indent.domain.Indent;
import com.ruoyi.project.market.type.service.IIndentTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/market/type")
public class IndentTypeController extends BaseController {

    @Autowired
    private IIndentTypeService indentTypeService;

    private String prefix = "market/type";

    @RequiresPermissions("market:type:view")
    @GetMapping()
    public String operlog() {
        return prefix + "/type";
    }


    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Indent indent) {
        startPage();
        List<Indent> indents=indentTypeService.selectIndentAll(indent);

        return  getDataTable(indents);
    }

    //@GetMapping("/edit")



}
