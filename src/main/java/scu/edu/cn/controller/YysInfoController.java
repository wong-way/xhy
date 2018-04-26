package scu.edu.cn.controller;
/**
 * @author 王明月
 * 处理育婴师相关信息相关操作
 */



import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import scu.edu.cn.dao.entity.YysInfo;
import scu.edu.cn.service.YysInfoService;
import scu.edu.cn.util.Error;

import java.util.List;

@Controller
@RequestMapping("/")
public class YysInfoController {
    @Autowired
    YysInfoService service;

    /**
     * API接口，返回育婴师列表json数据
     * @return 包含json格式数据的List
     */
    @ResponseBody
    @RequestMapping("api/yysInfoList")
    public List<YysInfo> getYysInfoList(){
        List<YysInfo> list=service.selectAllYysInfo();
        return  list;
    }


    /**
     * 页面控制器，返回页面信息
     * @return 育婴师页面
     */
    @RequestMapping("yysInfoList")
    public String getYysInfo(){
        return "yysInfoList.html";
    }

    /**
     * 根据传入的育婴师ID，删除育婴师信息
     * @param json
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/deleteYysInfo",method = RequestMethod.POST)
    @ResponseBody
    public Error deleteYysInfo(@RequestBody String json){

        Gson gson = new Gson();
        YysInfo info = gson.fromJson(json,YysInfo.class);
        System.out.println(info.getYysId());
        Error error = service.deleteYysInfo(info.getYysId());
        return error;
    }



    /**
     * 根据判断ID是否相同来增加育婴师信息
     * @param json
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/addYysInfo",method = RequestMethod.POST)
    @ResponseBody
    public Error addYysInfo(@RequestBody String json){
       // System.out.println("dddd");
        Gson gson = new Gson();
        YysInfo info = gson.fromJson(json,YysInfo.class);
        System.out.println(json);
        Error error = service.insertYysInfo(info);
        return error;
    }


    /**
     * 更新育婴师信息
     * @param json
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/updateYysInfo",method = RequestMethod.POST)
    @ResponseBody
    public Error updateYysInfo(@RequestBody String json){
        Gson gson = new Gson();
        System.out.println(json);
        YysInfo info = gson.fromJson(json,YysInfo.class);
        Error error = service.updateYysInfo(info);
        return error;
    }



}

