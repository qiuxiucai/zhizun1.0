package com.ruoyi.project.item.info.domain.VO;

import com.ruoyi.project.item.info.domain.Item;
import lombok.Data;

/**
 * 表继承客户表,客户表继承订单表
 * 17361 20:13
 */
@Data
public class ItemVO extends Item {

    private String sName; //项目负责人
    private String dName; //订单类别
}
