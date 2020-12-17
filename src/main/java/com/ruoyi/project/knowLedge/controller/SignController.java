package com.ruoyi.project.knowLedge.controller;


import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.knowLedge.domain.Read;
import com.ruoyi.project.knowLedge.service.ReadService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/knowledge/sign")
public class SignController  extends BaseController {
    @Autowired
    private ReadService readService;
    @RequiresPermissions("knowledge:sign:view")
    @GetMapping
    public String index(){
        return "/knowledge/sign/index";
    }


    @PostMapping("/list")
    @RequiresPermissions("knowledge:sign:list")
    @ResponseBody
    public TableDataInfo selectSign(Read read){
        startPage();
        List<Read> list=readService.selectSign(read);
        return getDataTable(list);
    }
}
