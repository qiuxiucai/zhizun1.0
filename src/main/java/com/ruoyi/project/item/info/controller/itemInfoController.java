package com.ruoyi.project.item.info.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.item.info.domain.Item;
import com.ruoyi.project.item.info.domain.VO.ItemVO;
import com.ruoyi.project.item.info.service.IItemInfoSerice;
import com.ruoyi.project.system.post.service.IPostService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目信息查看控制器
 * 17361 19:51
 */
@Controller
@RequestMapping("/item/info")
public class itemInfoController  extends BaseController {

    /**
     * 注入service层接口
     */
    @Autowired
    private IItemInfoSerice iItemInfoSerice;

    /**
     * 设置前缀
     */
    private String prefix = "item/info";

    /**
     * 返回展示页面
     */
    @RequiresPermissions("item:info:view")
    @GetMapping()
    public String info() {
        return prefix + "/info";
    }

    /**
     * 查询
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Item item) {
        startPage();
        List<ItemVO> list = iItemInfoSerice.list(item);
        return getDataTable(list);
    }

    /**
     * 查看详细信息页面跳转
     */
    @GetMapping("/detail/{id}")
    public String detailed(@PathVariable Integer id,Model model) {
        model.addAttribute("itemVO",iItemInfoSerice.selectById(id));
        return prefix + "/detail";
    }
}
