package com.ruoyi.project.product.series.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.Data;

@Data
public class Series extends BaseEntity {

    private Long seriesId;
    private String seriesName;
    private String remark;

}
