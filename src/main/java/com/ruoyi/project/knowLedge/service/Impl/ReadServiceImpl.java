package com.ruoyi.project.knowLedge.service.Impl;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.knowLedge.domain.Read;
import com.ruoyi.project.knowLedge.mapper.ReadMapper;
import com.ruoyi.project.knowLedge.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadServiceImpl implements ReadService {
    @Autowired
    private ReadMapper readMapper;

    @Override
    public List<Read> selectList(Read read) {

        return readMapper.selectList(read);

    }

    @Override
    public int insertReading(Read read) {
        return readMapper.insertRead(read);

    }

    @Override
    public Read selectById(Long kId) {

        return readMapper.selectById(kId);
    }

    @Override
    public int editByRead(Read read) {

        return readMapper.editByRead(read);
    }

    @Override
    public AjaxResult removeById(long[] ids) {
        int i = readMapper.removeById(ids);
        if (i > 0) {
            return AjaxResult.success("删除成功");
        }

        return AjaxResult.error("删除失败");
    }

    @Override
    public List<Read> selectSoft(Read read) {

        return readMapper.selectSoft(read);
    }

    @Override
    public List<Read> selectHard() {

        return readMapper.selectHard();
    }

    @Override
    public List<Read> selectSign(Read read) {
        return readMapper.selectSign(read);
    }
}
