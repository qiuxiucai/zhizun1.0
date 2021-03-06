package com.ruoyi.project.product.series.service;

import com.ruoyi.common.constant.SeriesConstants;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.product.details.mapper.GoodsMapper;
import com.ruoyi.project.product.series.domain.Series;
import com.ruoyi.project.product.series.mapper.SeriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("seriestype")
public class SeriesServiceImpl implements ISeriesService{

    @Autowired
    private SeriesMapper seriesMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Series> selectSeriesAll() {
        return seriesMapper.selectSeriesAll();
    }

    @Override
    public List<Series> selectSeries(Series series) {
        return seriesMapper.selectSeries(series);
    }

    @Override
    public AjaxResult saveSeries(Series series, String userName) {

        //设定series属性
        series.setCreateBy(userName);
        int result = seriesMapper.saveSeries(series);
        if (result == 1){
            return AjaxResult.success("添加系列类型成功");
        }
        return AjaxResult.error("添加系列类型失败");
    }

    @Override
    public String checkSeriesNameUnique(String seriesName) {
         Series series = seriesMapper.selectSeriesBySeriesName(seriesName);
        if (series != null) {
            return SeriesConstants.SERIESNAME_UNIQUE_EXISTS;
        }
        return SeriesConstants.SERIESNAME_UNIQUE_NOT_EXISTS;
    }

    @Override
    public Series selectSeriesTypeById(Long seriesId) {
        return seriesMapper.selectSeriesTypeById(seriesId);
    }

    @Override
    public AjaxResult editSeriesType(Series series, String userName) {
        series.setUpdateBy(userName);
        int result = seriesMapper.updateSeries(series);
        if(result == 1){
            return AjaxResult.success("修改系列类别成功");
        }
        return AjaxResult.error("修改系列类别失败");
    }

    @Override
    public AjaxResult removeSeriesByIds(Long[] ids) {

        for (Long id : ids) {
            Long num = goodsMapper.countGoods(id);
            if(num > 0){
                return AjaxResult.error("该系列下有内容,不能删除");
            }
        }

        int result = seriesMapper.removeSeriesByIds(ids);
        if(result == ids.length){
            return AjaxResult.success("删除产品系列类型成功");
        }
        return AjaxResult.error("删除产品系列类型失败");
    }


}
