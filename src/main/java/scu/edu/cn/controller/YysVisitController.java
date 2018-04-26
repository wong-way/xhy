package scu.edu.cn.controller;
/**
 * @author 王明月
 * 处理育婴师回访记录相关操作
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import scu.edu.cn.dao.entity.YysVisit;
import scu.edu.cn.dao.entity.YysVisitKey;
import scu.edu.cn.service.YysVisitService;
import scu.edu.cn.util.Error;

import java.util.List;

@Controller
@RequestMapping("/")
public class YysVisitController {
    @Autowired
    YysVisitService service;


    /**
     * API接口，返回育婴师回访记录列表json数据
     * @return 包含json格式数据的List
     */
    @ResponseBody
    @RequestMapping("api/yysVisitList")
    public List<YysVisit> getYysVisitList(){
        List<YysVisit> list=service.selectAllYysVisit();
        return  list;
    }


    /**
     * 页面控制器，返回页面信息
     * @return 育婴师回访记录页面
     */
    @RequestMapping("yysVisitList")
    public String getYysVisit(){
        return "yysVisitList.html";
    }



    /**
     * 根据传入的育婴师ID和回访日期，删除育婴师回访记录
     * @param yysVisit
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/deleteYysVisit",method = RequestMethod.POST)
    @ResponseBody
    public Error deleteYysVisit(@RequestBody YysVisit yysVisit){
        YysVisitKey key=new YysVisitKey();
        key.setYysId(yysVisit.getYysId());
        key.setVisitDate(yysVisit.getVisitDate());
        System.out.println(key.getYysId()+" "+key.getVisitDate());
        Error error = service.deleteYysVisit(key);

        return error;
    }


    /**
     * 根据传入的育婴师ID和回访日期，增加育婴师回访记录
     * @param yysVisit
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/addYysVisit",method = RequestMethod.POST)
    @ResponseBody
    public Error addYysVisit(@RequestBody  YysVisit yysVisit){
        Error error = service.insertYysVisit(yysVisit);
        return error;
    }


    /**
     * 根据传入的育婴师ID和回访日期，更新育婴师回访记录
     * @param yysVisit
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/updateYysVisit",method = RequestMethod.POST)
    @ResponseBody
    public Error updateYysVisit(@RequestBody YysVisit yysVisit){
        System.out.println(yysVisit.getContent()+" "+yysVisit.getYysId());
        Error error = service.updateYysVisit(yysVisit);
        return error;
    }
}
