package com.ruoyi.project.market.indent.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.item.info.domain.Item;
import com.ruoyi.project.market.indent.domain.Clientele;
import com.ruoyi.project.market.indent.domain.IndentAllVO;
import com.ruoyi.project.market.indent.mapper.IndentMapper;
import com.ruoyi.project.product.details.domain.Goods;
import com.ruoyi.project.staff.message.domain.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("indentAll")
public class IndentServiceImpl implements IIndentService {
    @Autowired
    private IndentMapper indentMapper;

    @Override
    public List<IndentAllVO> selectAll() {
        return indentMapper.selectAll();
    }

    @Override
    public IndentAllVO selectByNum(Integer pid) {
        return indentMapper.selectByNum(pid);
    }

    @Override
    public IndentAllVO select() {
        return null;
    }

    @Override
    public AjaxResult addAll(Item item, Clientele clientele, Goods goods) {
        System.out.println("+++++++++++++++"+item.getPStart());
        int i = indentMapper.addClientele(clientele);
        Integer cId = clientele.getCId();

        item.setCId(cId);

        int p =indentMapper.addItem(item);


         int o=  indentMapper.addGoods(goods);
        return null;
    }


}
