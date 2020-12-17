package com.ruoyi.project.product.series.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.product.series.domain.Series;

import java.util.List;

public interface ISeriesService {
    List<Series> selectSeriesAll();

    List<Series> selectSeries(Series series);


    /**
     * 保存公告类型
     * @param series
     * @param userName
     * @return
     */
    AjaxResult saveSeries(Series series, String userName);

    /**
     * 校验唯一性
     * @param SeriesName
     * @return
     */
    String checkSeriesNameUnique(String SeriesName);

    Series selectSeriesTypeById(Long seriesId);

    AjaxResult editSeriesType(Series series, String userName);

    AjaxResult removeSeriesByIds(Long[] ids);
}
