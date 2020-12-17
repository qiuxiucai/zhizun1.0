package com.ruoyi.project.knowLedge.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * @author 王国玉
 */
@Data
public class Read extends BaseEntity {

    private Integer kId;
    private String kName;
    private String kContent;
    private Integer kType; //1是硬装，0是软装
    private String kUrl;
    private String kBenchmarking;//1是标杆项目，0是非标杆项目


}
