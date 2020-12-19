package com.ruoyi.project.product.series.mapper;


import com.ruoyi.project.product.series.domain.Series;


import java.util.List;

public interface SeriesMapper {

    List<Series> selectSeriesAll();


    List<Series> selectSeries(Series series);

    int saveSeries(Series series);

    Series selectSeriesBySeriesName(String seriesName);

    Series selectSeriesTypeById(Long seriesId);

    int updateSeries(Series series);

    int removeSeriesByIds(Long[] ids);

//    String  selectMaterialsAll();
}

