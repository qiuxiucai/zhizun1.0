package com.ruoyi.project.product.style.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.product.style.domain.ProductStyle;
import com.ruoyi.project.product.style.service.IProductStyleServie;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class StyleController extends BaseController {


    @Autowired
    private IProductStyleServie iProductStyleServie;

    private String prefix = "product/style";

    @RequiresPermissions("product:style:view")
    @GetMapping()
    public String style(){

        return prefix + "/style";
    }

    @RequiresPermissions("product:style:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProductStyle productStyle){
        startPage();
//        List<Series> seriesList = iSeriesService.selectSeriesAll();
        List<ProductStyle> styleList = iProductStyleServie.selectProductStyle(productStyle);

        return getDataTable(styleList);
    }

    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }

    @RequiresPermissions("product:style:add")
    @PostMapping("add")
    @ResponseBody
    public AjaxResult save(ProductStyle productStyle){

        User user = getSysUser();

        return  iProductStyleServie.saveProductStyle(productStyle,user.getUserName());
    }

    //cmsnotice/type/checkTypeNameUnique
    @PostMapping("/checkProductStyleNameUnique")
    @ResponseBody
    public String  checkProductStyleNameUnique(String productStyleName){
        return iProductStyleServie.checkProductStyleNameUnique(productStyleName);
    }


    @GetMapping("/edit/{styleId}")
    public String edit(@PathVariable Long styleId, Model model){
        model.addAttribute("ProductStyle", iProductStyleServie.selectProductStyleById(styleId));

        return prefix + "/edit";

    }


    @RequiresPermissions("product:style:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult edit(ProductStyle productStyle){

        User user = getSysUser();
        return iProductStyleServie.editStyleType(productStyle,user.getUserName());
    }

    @RequiresPermissions("product:style:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Long[] ids){

        return iProductStyleServie.removeStyleByIds(ids);
    }



}
