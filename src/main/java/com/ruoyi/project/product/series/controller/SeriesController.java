package com.ruoyi.project.product.series.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.product.series.domain.Series;
import com.ruoyi.project.product.series.service.ISeriesService;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product/series")
public class SeriesController extends BaseController {

    @Autowired
    private ISeriesService iSeriesService;

    private String prefix = "product/series";

    @RequiresPermissions("product:series:view")
    @GetMapping()
    public String series(){

        return prefix + "/series";
    }

    @RequiresPermissions("product:series:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Series series){
        startPage();
//        List<Series> seriesList = iSeriesService.selectSeriesAll();
        List<Series> seriesList = iSeriesService.selectSeries(series);

        return getDataTable(seriesList);
    }

    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }

    @RequiresPermissions("product:series:add")
    @PostMapping("add")
    @ResponseBody
    public AjaxResult save(Series series){

        User user = getSysUser();

        return  iSeriesService.saveSeries(series,user.getUserName());
    }

    //cmsnotice/type/checkTypeNameUnique
    @PostMapping("/checkSeriesNameUnique")
    @ResponseBody
    public String  checkSeriesNameUnique(String seriesName){
        return iSeriesService.checkSeriesNameUnique(seriesName);
    }


    @GetMapping("/edit/{seriesId}")
    public String edit(@PathVariable Long seriesId, Model model){
        model.addAttribute("Series", iSeriesService.selectSeriesTypeById(seriesId));

        return prefix + "/edit";

    }


    @RequiresPermissions("product:series:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult edit(Series series){

        User user = getSysUser();
        return iSeriesService.editSeriesType(series,user.getUserName());
    }

    @RequiresPermissions("product:series:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Long[] ids){

        return iSeriesService.removeSeriesByIds(ids);
    }





}
