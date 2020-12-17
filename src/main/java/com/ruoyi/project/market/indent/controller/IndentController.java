package com.ruoyi.project.market.indent.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.market.indent.domain.IndentAllVO;
import com.ruoyi.project.market.indent.service.IIndentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/market/indent")
public class IndentController extends BaseController {

    private String prefix = "market/indent";

    @Autowired
    private IIndentService indentService;

    @RequiresPermissions("market:indent:view")
    @GetMapping()
    public String operlog() {
        return prefix + "/indent";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
       List<IndentAllVO> indentAllVOS= indentService.selectAll();
        return  getDataTable(indentAllVOS);
    }

    /**
     * 查看订单信息 项目信息 客户信息 产品信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model){
        IndentAllVO indentAllVO = indentService.selectByNum(id);
        System.out.println(indentAllVO);
        model.addAttribute("IndentAllVO",indentAllVO);
        return prefix +"/detail1";
    }

    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }


}
