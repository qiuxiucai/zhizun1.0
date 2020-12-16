package com.ruoyi.project.market.type.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.market.indent.domain.Indent;
import com.ruoyi.project.market.type.domain.IndentVO;
import com.ruoyi.project.market.type.service.IIndentTypeService;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
        List<IndentVO> indents=indentTypeService.selectIndentAll(indent);

        return  getDataTable(indents);
    }

//    @GetMapping("/edit/{dId}")
//
//    public String edit(@PathVariable("dId") Integer dId, Model model)
//    {
//        model.addAttribute("indentType",indentTypeService.selectIndentName(dId));
//        return prefix + "/edit";
//    }
//
//    @ResponseBody
//    @RequiresPermissions("market:type:edit")
//    @PostMapping("/edit")
//
//    public AjaxResult edit(Indent indent){
//
//        return indentTypeService.updateNotice(indent);
//
//    }


}
