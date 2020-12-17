package com.ruoyi.project.knowLedge.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.knowLedge.domain.Read;

import java.util.List;

public interface ReadService {

    List<Read> selectList(Read read);


    int insertReading(Read read);

    Read selectById(Long kId);

    int editByRead(Read read);

    AjaxResult removeById(long[] ids);

    List<Read> selectSoft(Read read);

    List<Read> selectHard();

    List<Read> selectSign(Read read);
}
