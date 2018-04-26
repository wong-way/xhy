package scu.edu.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.PromotionRecord;
import scu.edu.cn.service.PromotionRecordService;
import scu.edu.cn.util.Error;

import java.util.List;

@Controller
@RequestMapping("/")
public class PromotionRecordController {
    @Autowired
    PromotionRecordService service;

    /**
     *获取所有晋升记录
     *
     * @return List<PromotionRecord>对象
     */
    @ResponseBody
    @RequestMapping("api/promotionRecordList")
    public List<PromotionRecord> getPromotionRecordList(){
        List<PromotionRecord> list = service.selectAllPromotionRecord();
        return list;
    }

    /**
     *获取晋升记录
     *
     * @return 晋升记录页面
     */
    @RequestMapping("promotionRecordList")
    public String getPromotionRecord(){
        return "promotionRecordList.html";

    }

    /**
     *删除晋升记录
     *
     * @param promotionRecordId
     * @return error对象
     */
    @RequestMapping(value = "api/deletePromotionRecord",method = RequestMethod.POST)
    @ResponseBody
    public Error deletePromotionRecord(@RequestParam("promotionRecordId") Integer promotionRecordId){

        Error error = service.deletePromotionRecordById(promotionRecordId);
        return error;
    }

    /**
     *新增晋升记录
     *
     * @param Record
     * @return error对象
     */
    @RequestMapping(value = "api/addPromotionRecord",method = RequestMethod.POST)
    @ResponseBody
    public Error addPromotionRecord(@RequestBody PromotionRecord Record){

        Error error = service.insertPromotionRecord(Record);
        return error;
    }

    /**
     *编辑晋升记录
     *
     * @param Record
     * @return error对象
     */
    @RequestMapping(value = "api/updatePromotionRecord",method = RequestMethod.POST)
    @ResponseBody
    public Error updatePromotionRecord(@RequestBody PromotionRecord Record){

        Error error = service.updatePromotionRecord(Record);
        return error;
    }
}
