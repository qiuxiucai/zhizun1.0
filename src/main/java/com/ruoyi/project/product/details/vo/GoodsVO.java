package com.ruoyi.project.product.details.vo;

import com.ruoyi.project.product.details.domain.Goods;
import lombok.Data;

@Data
public class GoodsVO extends Goods {

    private String seriesName;
    private String styleName;
    private String sizeName;


}
