package scu.edu.cn.controller;
/**
 * @author 王明月
 * 处理育婴师工作经历相关操作
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import scu.edu.cn.dao.entity.YysExperience;
import scu.edu.cn.service.YysExperienceService;
import scu.edu.cn.util.Error;

import java.util.List;

@Controller
@RequestMapping("/")
public class YysExperienceController {
    @Autowired
    YysExperienceService service;

    /**
     * API接口，返回育婴师工作经历列表json数据
     * @return 包含json格式数据的List
     */
    @ResponseBody
    @RequestMapping("api/yysExperienceList")
    public List<YysExperience> getYysExperienceList(){
        List<YysExperience> list=service.selectAllYysExperience();
        return  list;
    }

    /**
     * 页面控制器，返回页面信息
     * @return 育婴师工作经历页面
     */
    @RequestMapping("yysExperienceList")
    public String getYysExperience(){
        return "yysExperienceList.html";
    }



    /**
     * 根据传入的育婴师工作经历ID，删除育婴师工作经历
     * @param yysExperience
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/deleteYysExperience",method = RequestMethod.POST)
    @ResponseBody
    public Error deleteYysInfo(@RequestBody YysExperience yysExperience){
        System.out.println(yysExperience.getYysExperienceId());
        Error error = service.deleteYysExperience(yysExperience.getYysExperienceId());
        return error;
    }


    /**
     * 根据传入的育婴师工作经历ID，增加育婴师工作经历
     * @param yysExperience
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/addYysExperience",method = RequestMethod.POST)
    @ResponseBody
    public Error addYysExperience(@RequestBody YysExperience yysExperience){
        System.out.println(yysExperience.getYysCustomerEvaluation()+" "+yysExperience.getYysWorkContent());
        Error error = service.insertYysExperience(yysExperience);
        return error;
    }

    /**
     * 根据传入的育婴师工作经历ID，更新育婴师工作经历
     * @param yysExperience
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/updateYysExperience",method = RequestMethod.POST)
    @ResponseBody
    public Error updateYysExperience(@RequestBody YysExperience yysExperience){
        System.out.println(yysExperience.getYysCustomerEvaluation()+" "+yysExperience.getYysWorkContent());
        Error error = service.updateYysExperience(yysExperience);
        return error;
    }
}
