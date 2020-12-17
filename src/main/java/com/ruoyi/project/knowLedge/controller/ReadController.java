package com.ruoyi.project.knowLedge.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.knowLedge.domain.Read;
import com.ruoyi.project.knowLedge.service.ReadService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/knowledge/read")
public class ReadController extends BaseController {
    @Autowired
    private ReadService readService;
    private String prefix = "knowledge/read";

    @RequiresPermissions("knowledge:read:view")
    @GetMapping()
    public String reading() {
        return prefix + "/reading";
    }

    @RequiresPermissions("knowledge:read:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo selectList(Read read) {
        startPage();
        List<Read> list = readService.selectList(read);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String addIndex() {
        return prefix + "/add";
    }

    @RequiresPermissions("knowledge:read:add")
    @ResponseBody
    @PostMapping("/add")
    public AjaxResult add(Read read) {
        int i = readService.insertReading(read);
        if (i > 0) {
            return AjaxResult.success("添加成功");
        }
        return AjaxResult.error("添加失败");
    }


    @GetMapping("/edit/{kId}")
    public String editIndex(@PathVariable Long kId, Model model) {
        model.addAttribute("read", readService.selectById(kId));
        return prefix + "/edit";
    }

    @RequiresPermissions("knowledge:read:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult edit(Read read) {
        int i = readService.editByRead(read);
        return toAjax(i);
    }

    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("knowledge:read:remove")
    public AjaxResult removeRead(long[] ids) {

        return readService.removeById(ids);
    }



}
