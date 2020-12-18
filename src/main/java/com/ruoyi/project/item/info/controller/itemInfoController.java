package com.ruoyi.project.item.info.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.poi.ExcelUtilVO;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.item.info.domain.Item;
import com.ruoyi.project.item.info.domain.VO.ClienTeleAllVO;
import com.ruoyi.project.item.info.domain.VO.ItemAllVO;
import com.ruoyi.project.item.info.domain.VO.ItemVO;
import com.ruoyi.project.item.info.service.IItemInfoSerice;
import com.ruoyi.project.market.indent.domain.Clientele;
import com.ruoyi.project.product.details.domain.Goods;
import com.ruoyi.project.staff.message.domain.Staff;
import com.ruoyi.project.system.post.service.IPostService;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    public TableDataInfo list(Item item,Model model) {
        startPage();
        List<ItemVO> list = iItemInfoSerice.list(item);
        model.addAttribute("ItemVO",list);
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

    /**
     * 导出
     */
    @Log(title = "项目详细信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Integer pid) {
        ItemAllVO itemAllVO = iItemInfoSerice.selectByIdVO(pid);
        ExcelUtilVO<ItemAllVO> itemVOExcelUtilVO = new ExcelUtilVO<>(ItemAllVO.class);
        List<ItemAllVO> itemVOS = new ArrayList<>();
        itemVOS.add(itemAllVO);
        return itemVOExcelUtilVO.exportExcel(itemVOS,"itemVO");
    }

    /**
     * 修改项目信息
     */
    @GetMapping("/edit/{pid}")
    public String edit(@PathVariable Integer pid,Model model){
        model.addAttribute("ItemAllVO",iItemInfoSerice.selectById(pid));
        return prefix + "/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult edit(Item item, ClienTeleAllVO clientele, String DateStart, String DateEnd) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date pStart = dateFormat.parse(DateStart);
        Date pEnd = dateFormat.parse(DateEnd);
        item.setPStart(pStart);
        item.setPEnd(pEnd);
        return iItemInfoSerice.EditAll(item, clientele);
    }

}
