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
@RequestMapping("knowledge/soft")
public class SoftController extends BaseController {
    /**
     * 软装
     */

    @Autowired
    private ReadService readService;

    private String prefix="/knowledge/soft";
    @RequiresPermissions("knowledge:soft:view")
    @GetMapping
    public String selectSoft(){
        return prefix+"/index";
    }

    @RequiresPermissions("knowledge:soft:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo selectSoft(Read read){
        startPage();
        List<Read> list=readService.selectSoft(read);
        return getDataTable(list);
    }
}
