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
@RequestMapping("knowledge/hard")
public class HardController extends BaseController {

    @Autowired
    private ReadService readService;
    private String prex="/knowledge/hard";

    @RequiresPermissions("knowledge:hard:view")
    @GetMapping()
    public String selectIndex(){
        return prex+"/index";
    }

    @ResponseBody
    @PostMapping("/list")
    @RequiresPermissions("knowledge:hard:list")
    public TableDataInfo select(Read read){
        startPage();
        List<Read> list=readService.selectHard();
        return getDataTable(list);

    }
}
