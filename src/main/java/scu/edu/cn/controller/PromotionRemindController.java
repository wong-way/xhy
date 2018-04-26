package scu.edu.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.PromotionRemind;
import scu.edu.cn.service.PromotionRemindService;
import scu.edu.cn.util.Error;

import java.util.List;

@Controller
@RequestMapping("/")
public class PromotionRemindController {
    @Autowired
    PromotionRemindService service;

    /**
     *获取所有晋升提醒
     *
     * @return List<PromotionRemind>对象
     */
    @ResponseBody
    @RequestMapping("api/promotionRemindList")
    public List<PromotionRemind> getPromotionRemindList(){
        List<PromotionRemind> list = service.selectAllPromotionRemind();
        return list;
    }

    /**
     *获取晋升提醒
     *
     * @return 晋升提醒页面
     */
    @RequestMapping("promotionRemindList")
    public String getPromotionRemind(){
        return "promotionRemindList.html";

    }

    /**
     *删除晋升提醒
     *
     * @param promotionRemindId
     * @return error对象
     */
    @RequestMapping(value = "api/deletePromotionRemind",method = RequestMethod.POST)
    @ResponseBody
    public Error deletePromotionRemind(@RequestParam("promotionRemindId") Integer promotionRemindId){

        Error error = service.deletePromotionRemindById(promotionRemindId);
        return error;
    }

    /**
     *新增晋升提醒
     *
     * @param Remind
     * @return error对象
     */
    @RequestMapping(value = "api/addPromotionRemind",method = RequestMethod.POST)
    @ResponseBody
    public Error addPromotionRemind(@RequestBody PromotionRemind Remind){

        Error error = service.insertPromotionRemind(Remind);
        return error;
    }

    /**
     *编辑晋升提醒
     *
     * @param Remind
     * @return error对象
     */
    @RequestMapping(value = "api/updatePromotionRemind",method = RequestMethod.POST)
    @ResponseBody
    public Error updatePromotionRemind(@RequestBody PromotionRemind Remind){

        Error error = service.updatePromotionRemind(Remind);
        return error;
    }
}
