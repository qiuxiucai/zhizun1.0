package com.ruoyi.project.item.info.domain.VO;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.aspectj.lang.annotation.Excels;
import com.ruoyi.project.item.info.domain.Item;
import lombok.Data;

/**
 * 表继承客户表,客户表继承订单表
 * 17361 20:13
 */
@Data
public class ItemVO extends Item {

    @Excel(name = "项目负责人")
    private String sName; //项目负责人
    @Excel(name = "订单类别")
    private String dName; //订单类别
    @Excel(name = "订单产品数量")
    private Integer dAmount; //订单产品数量

    private Integer TypeId;
    @Excel(name = "客户类型")
    private String TypeName;

}
