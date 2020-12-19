package com.ruoyi.project.product.size.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.Data;

@Data
public class ProductSize extends BaseEntity {

    private Long sizeId;
    private String sizeName;
    private String sizeRemark;

}
