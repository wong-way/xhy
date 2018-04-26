package scu.edu.cn.controller;
/**
 * @author 王明月
 * 处理结算与评价记录相关操作
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import scu.edu.cn.dao.entity.YysEvaluation;
import scu.edu.cn.dao.entity.YysEvaluationKey;
import scu.edu.cn.service.YysEvaluationService;
import scu.edu.cn.util.Error;

import java.util.List;

@Controller
@RequestMapping("/")
public class YysEvaluationController {
    @Autowired
    YysEvaluationService service;

    /**
     * API接口，返回结算与评价记录列表json数据
     * @return 包含json格式数据的List
     */
    @ResponseBody
    @RequestMapping("api/yysEvaluationList")
    public List<YysEvaluation> getYysEvaluationList(){
        List<YysEvaluation> list=service.selectAllYysEvaluation();
        return  list;
    }

    /**
     * 页面控制器，返回页面信息
     * @return 结算与评价记录页面
     */
    @RequestMapping("yysEvaluationList")
    public String getYysEvaluation(){
        return "yysEvaluationList.html";
    }


    /**
     * 根据传入的育婴师ID和合同ID，删除结算与评价记录
     * @param yysEvaluation
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/deleteYysEvaluation",method = RequestMethod.POST)
    @ResponseBody
    public Error deleteYysEvaluation(@RequestBody YysEvaluation yysEvaluation){
        YysEvaluationKey key=new YysEvaluationKey();
        key.setYysId(yysEvaluation.getYysId());
        key.setContractId(yysEvaluation.getContractId());
        System.out.println(key.getYysId()+" "+key.getContractId());
        Error error = service.deleteYysEvaluation(key);

        return error;
    }


    /**
     * 根据传入的育婴师ID和合同ID，增加结算与评价记录
     * @param yysEvaluation
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/addYysEvaluation",method = RequestMethod.POST)
    @ResponseBody
    public Error addYysEvaluation(@RequestBody  YysEvaluation yysEvaluation){
        Error error = service.insertYysEvaluation(yysEvaluation);
        return error;
    }


    /**
     * 根据传入的育婴师ID和合同ID，更新结算与评价记录
     * @param yysEvaluation
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/updateYysEvaluation",method = RequestMethod.POST)
    @ResponseBody
    public Error updateYysEvaluation(@RequestBody YysEvaluation yysEvaluation){
        Error error = service.updateYysEvaluation(yysEvaluation);
        return error;
    }
}
