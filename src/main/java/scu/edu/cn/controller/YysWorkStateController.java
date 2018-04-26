package scu.edu.cn.controller;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.YysWorkState;
import scu.edu.cn.service.YysWorkStateService;
import scu.edu.cn.util.Error;

import java.util.List;

@Controller
@RequestMapping("/")
public class YysWorkStateController {

    @Autowired
    YysWorkStateService yysWorkStateService;

    /**
     * 添加育婴师工作状态
     * @param json
     * @return
     */
    @RequestMapping(value = "api/addYysWorkState",method = RequestMethod.POST)
    @ResponseBody
    public Error addYysWorkState(@RequestBody YysWorkState json){
//        Gson gson = new Gson();
//        YysWorkState yysWorkState = gson.fromJson(json,YysWorkState.class);
        Error error = yysWorkStateService.insertYysWorkState(json);
        return error;
    }

    /**
     * 查找育婴师工作状态
     * @param json
     * @return
     */
    @RequestMapping(value = "api/selectYysWorkState",method = RequestMethod.POST)
    @ResponseBody
    public Error selectYysWorkState(@RequestBody String json){
        Gson gson = new Gson();
        YysWorkState yysWorkState = gson.fromJson(json,YysWorkState.class);
        Error error = yysWorkStateService.selectYysWorkStateById(yysWorkState.getYysId()).getError();
        return error;
    }

    /**
     * 删除育婴师工作状态
     * @param json
     * @return
     */
    @RequestMapping(value = "api/deleteYysWorkState",method = RequestMethod.POST)
    @ResponseBody
    public Error deleteYysWorkState(@RequestParam("yysId") Integer json){

//        Gson gson = new Gson();
//        YysWorkState yysWorkState = gson.fromJson(json,YysWorkState.class);
//        System.out.println(yysWorkState.getYysId());
        System.out.println(json);
        Error error = yysWorkStateService.deleteYysWorkStateById(json);
        return error;
    }

    /**
     * 更新育婴师工作状态
     * @param json
     * @return
     */
    @RequestMapping(value = "api/updateYysWorkState",method = RequestMethod.POST)
    @ResponseBody
    public Error updateYysWorkState(@RequestBody YysWorkState json){
//        Gson gson = new Gson();
//        System.out.println(json);
//        YysWorkState yysWorkState = gson.fromJson(json,YysWorkState.class);
        //info.setToken(new Token().getToken());
        Error error = yysWorkStateService.updateYysWorkState(json);
        return error;
    }

    /**
     * 查看育婴师工作状态，返回页面
     * @return
     */
    @RequestMapping("yysWorkStateList")
    public String getYysWorkState(){
        return "yysWorkStateList.html";
    }

    /**
     * 查看育婴师工作状态表
     * @return
     */
    @ResponseBody
    @RequestMapping("api/yysWorkStateList")
    public List<YysWorkState> getYysWorkStateList(){
        List<YysWorkState> list = yysWorkStateService.selectAllYysWorkState().getData();
        return list;
    }

}
