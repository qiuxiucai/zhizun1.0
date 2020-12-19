package com.ruoyi.project.product.style.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.Data;

@Data
public class ProductStyle extends BaseEntity {

    private Long styleId;
    private String styleName;
    private String styleRemark;
}
