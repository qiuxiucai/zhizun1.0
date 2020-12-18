package com.ruoyi.project.market.indent.controller;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.item.info.domain.Item;
import com.ruoyi.project.market.indent.domain.Clientele;
import com.ruoyi.project.market.indent.domain.IndentAllVO;
import com.ruoyi.project.market.indent.service.IIndentService;
import com.ruoyi.project.product.details.domain.Goods;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/market/indent")
public class IndentController extends BaseController {

    private String prefix = "market/indent";

    @Autowired
    private IIndentService indentService;

    @RequiresPermissions("market:indent:view")
    @GetMapping()
    public String operlog() {
        return prefix + "/indent";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
       List<IndentAllVO> indentAllVOS= indentService.selectAll();
        return  getDataTable(indentAllVOS);
    }

    /**
     * 查看订单信息 项目信息 客户信息 产品信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model){
        IndentAllVO indentAllVO = indentService.selectByNum(id);
        System.out.println(indentAllVO);
        model.addAttribute("IndentAllVO",indentAllVO);
        return prefix +"/detail1";
    }


    /**
     * add跳转页面
     * @return
     */
    @GetMapping("/add")
    public String add(){

        return prefix + "/add";
    }

    /**
     * 添加 订单 项目 客户
     * @param
     * @return
     */

    @PostMapping("/add")
    public AjaxResult addAll(Item item, Clientele clientele, Goods goods) throws ParseException {

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
//        Date parse = simpleDateFormat.parse(dataStart);
//        System.out.println(parse);
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat1.format(parse);
//        System.out.println(format);
//        item.setPStart(parse);
//        System.out.println(item);
//        char del='T';
//        String EndTime="";
//        //2020-12-25T22:22
//        for(int i=0;i<dataStart.length();i++){
//            if(dataStart.charAt(i)!=del){
//                EndTime+=dataStart.charAt(i);
//            }
//        }
//        String s1 = EndTime.substring(0, 10);
//        String s2=  EndTime.substring(10,14);
//        EndTime=s1+" "+s2;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//转换时区格式
//        Date etime=sdf.parse(EndTime); //Mon Nov 30 15:02:00 CST 2020
//        item.setPStart(etime);
//
//
//        char del1='T';
//        String EndTime1="";
//        //2020-12-25T22:22
//        for(int i=0;i<dataEnd.length();i++){
//            if(dataEnd.charAt(i)!=del1){
//                EndTime1+=dataEnd.charAt(i);
//            }
//        }
//        String s3 = EndTime1.substring(0, 10);
//        String s4=  EndTime1.substring(10,14);
//        EndTime1=s3+" "+s4;
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");//转换时区格式
//        Date etime1=sdf1.parse(EndTime1); //Mon Nov 30 15:02:00 CST 2020
//
//        item.setPEnd(etime1);



       return  indentService.addAll(item,clientele,goods);

    }

}
