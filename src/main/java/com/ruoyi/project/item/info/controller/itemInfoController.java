package com.ruoyi.project.item.info.controller;

import com.ruoyi.project.item.info.service.IItemInfoSerice;
import com.ruoyi.project.system.post.service.IPostService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目信息查看控制器
 * 17361 19:51
 */
@Controller
@RequestMapping("/item/info")
public class itemInfoController {

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
     *
     */
    @RequiresPermissions("item:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }


}
