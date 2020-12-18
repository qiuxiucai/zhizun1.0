package com.ruoyi.project.knowLedge.mapper;

import com.ruoyi.project.knowLedge.domain.Read;

import java.util.List;

public interface ReadMapper {

    List<Read> selectList(Read read);

    int insertRead(Read read);

    Read selectById(Long kId);

    int editByRead(Read read);

    int removeById(long[] ids);

    List<Read> selectSoft(Read read);

    List<Read> selectHard();

    List<Read> selectSign(Read read);
}
