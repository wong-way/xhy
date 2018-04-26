package scu.edu.cn.controller;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.ReceptionSituation;
import scu.edu.cn.service.ReceptionSituationService;
import scu.edu.cn.util.Error;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReceptionSituationController {

    @Autowired
    ReceptionSituationService receptionSituationService;

    /**
     * 添加接待状况记录
     * @param json
     * @return
     */
    @RequestMapping(value = "api/addReceptionSituation",method = RequestMethod.POST)
    @ResponseBody
    public Error addReceptionSituation(@RequestBody ReceptionSituation json){
//        Gson gson = new Gson();
//        ReceptionSituation receptionSituation = gson.fromJson(json,ReceptionSituation.class);
        Error error = receptionSituationService.insertReceptionSituation(json);
        return error;
    }

    /**
     * 查找接待状况记录
     * @param json
     * @return
     */
    @RequestMapping(value = "api/selectReceptionSituation",method = RequestMethod.POST)
    @ResponseBody
    public Error selectReceptionSituation(@RequestBody String json){
        Gson gson = new Gson();
        ReceptionSituation receptionSituation = gson.fromJson(json,ReceptionSituation.class);
        Error error = receptionSituationService.selectReceptionSituationById(receptionSituation.getReceptionId()).getError();
        return error;
    }

    /**
     * 删除接待状况记录
     * @param json
     * @return
     */
    @RequestMapping(value = "api/deleteReceptionSituation",method = RequestMethod.POST)
    @ResponseBody
    public Error deleteReceptionSituation(@RequestParam("receptionId") Integer json){

//        Gson gson = new Gson();
//        ReceptionSituation receptionSituation = gson.fromJson(json,ReceptionSituation.class);
//        System.out.println(receptionSituation.getReceptionId());
        Error error = receptionSituationService.deleteReceptionSituationById(json);
        return error;
    }

    /**
     * 更新接待状况记录
     * @param json
     * @return
     */
    @RequestMapping(value = "api/updateReceptionSituation",method = RequestMethod.POST)
    @ResponseBody
    public Error updateReceptionSituation(@RequestBody ReceptionSituation json){
//        Gson gson = new Gson();
//        System.out.println(json);
//        ReceptionSituation receptionSituation = gson.fromJson(json,ReceptionSituation.class);
        //info.setToken(new Token().getToken());
        Error error = receptionSituationService.updateReceptionSituation(json);
        return error;
    }

    /**
     * 查看接待状况，返回页面
     * @return
     */
    @RequestMapping("receptionSituationList")
    public String getReceptionSituation(){
        return "receptionSituationList.html";
    }

    /**
     * 查看所有的接待情况
     * @return
     */
    @ResponseBody
    @RequestMapping("api/receptionSituationList")
    public List<ReceptionSituation> getReceptionSituationList(){
        List<ReceptionSituation> list = receptionSituationService.selectAllReceptionSituation().getData();
        return list;
    }
}
