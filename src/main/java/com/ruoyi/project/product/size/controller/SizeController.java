package com.ruoyi.project.product.size.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.product.size.domain.ProductSize;
import com.ruoyi.project.product.size.service.IProductSizeService;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product/size")
public class SizeController extends BaseController {

    @Autowired
    private IProductSizeService iProductSizeService;

    private String prefix = "product/size";

    @RequiresPermissions("product:size:view")
    @GetMapping()
    public String size(){

        return prefix + "/size";
    }

    @RequiresPermissions("product:size:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProductSize productSize){
        startPage();
//        List<Series> seriesList = iSeriesService.selectSeriesAll();
        List<ProductSize> sizesList = iProductSizeService.selectProductSize(productSize);

        return getDataTable(sizesList);
    }

    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }

    @RequiresPermissions("product:size:add")
    @PostMapping("add")
    @ResponseBody
    public AjaxResult save(ProductSize productSize){

        User user = getSysUser();

        return  iProductSizeService.saveProductSize(productSize,user.getUserName());
    }

    //cmsnotice/type/checkTypeNameUnique
    @PostMapping("/checkProductSizeNameUnique")
    @ResponseBody
    public String  checkProductSizeNameUnique(String sizeName){
        return iProductSizeService.checkProductSizeNameUnique(sizeName);
    }


    @GetMapping("/edit/{sizeId}")
    public String edit(@PathVariable Long sizeId, Model model){
        model.addAttribute("ProductSize", iProductSizeService.selectProductSizeById(sizeId));

        return prefix + "/edit";

    }


    @RequiresPermissions("product:size:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult edit(ProductSize productSize){

        User user = getSysUser();
        return iProductSizeService.editSizeType(productSize,user.getUserName());
    }

    @RequiresPermissions("product:size:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Long[] ids){

        return iProductSizeService.removeSizeByIds(ids);
    }


}
