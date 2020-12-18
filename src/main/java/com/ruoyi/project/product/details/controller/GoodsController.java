package com.ruoyi.project.product.details.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.product.details.domain.Goods;
import com.ruoyi.project.product.details.service.IGoodsService;
import com.ruoyi.project.product.details.vo.GoodsVO;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.modelmbean.ModelMBean;
import java.util.List;

@Controller
@RequestMapping("/product/details")
public class GoodsController extends BaseController {

    //注入service层
    @Autowired
    private IGoodsService iGoodsService;

    public String prefix = "/product/details";

    @RequiresPermissions("product:details:view")
    @GetMapping()
    public String details(){
        return prefix + "/details";
    }

    //list请求

    @RequiresPermissions("product:details:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Goods goods){
        startPage();
        List<GoodsVO> goodsVOList = iGoodsService.selectGoodsVO(goods);

        return getDataTable(goodsVOList);
    }

    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }

    //添加
    @RequiresPermissions("product:details:add")
    @PostMapping("add")
    @ResponseBody
    public AjaxResult save(Goods goods){
        User user = getSysUser();
        return iGoodsService.savegoods(goods,user.getUserName());
    }

    @PostMapping("/checkProductModelNameUnique")
    @ResponseBody
    public String checkProductModelNameUnique(String productModel){
        return iGoodsService.checkProductModelNameUnique(productModel);
    }

    @PostMapping("/checkProductNameUnique")
    @ResponseBody
    public String checkProductNameUnique(String productName){
        return iGoodsService.checkProductNameUnique(productName);
    }

    //编辑页面
    @GetMapping("/edit/{productId}")
    public String edit(@PathVariable Long productId, Model model){

        model.addAttribute("goods", iGoodsService.selectGoodsById(productId));


        return prefix + "/edit";
    }


    //开始编辑
    @RequiresPermissions("product:details:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult edit(Goods goods){
        User user = getSysUser();
        return iGoodsService.editGoods(goods,user.getUserName());
    }



}
