package scu.edu.cn.controller;
/**
 * @author 王明月
 * 处理客户回访记录相关操作
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import scu.edu.cn.dao.entity.CustomerVisit;
import scu.edu.cn.dao.entity.CustomerVisitKey;
import scu.edu.cn.service.CustomerVisitService;
import scu.edu.cn.util.Error;

import java.util.List;

@Controller
@RequestMapping("/")
public class CustomerVisitController {
    @Autowired
    CustomerVisitService service;


    /**
     * API接口，返回客户回访记录列表json数据
     * @return 包含json格式数据的List
     */
    @ResponseBody
    @RequestMapping("api/customerVisitList")
    public List<CustomerVisit> getCustomerVisitList(){
        List<CustomerVisit> list=service.selectAllCustomerVisit();
        return  list;
    }


    /**
     * 页面控制器，返回页面信息
     * @return 客户回访记录页面
     */
    @RequestMapping("customerVisitList")
    public String getCustomerVisit(){
        return "customerVisitList.html";
    }



    /**
     * 根据传入的客户ID和回访日期，删除客户回访记录
     * @param customerVisit
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/deleteCustomerVisit",method = RequestMethod.POST)
    @ResponseBody
    public Error deleteCustomerVisit(@RequestBody CustomerVisit customerVisit){
        CustomerVisitKey key=new CustomerVisitKey();
        key.setCustomerId(customerVisit.getCustomerId());
        key.setVisitDate(customerVisit.getVisitDate());
        System.out.println(key.getCustomerId()+" "+key.getVisitDate());
        Error error = service.deleteCustomerVisit(key);

        return error;
    }


    /**
     * 根据传入的客户ID和回访日期，增加客户回访记录
     * @param customerVisit
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/addCustomerVisit",method = RequestMethod.POST)
    @ResponseBody
    public Error addCustomerVisit(@RequestBody  CustomerVisit customerVisit){
        Error error = service.insertCustomerVisit(customerVisit);
        return error;
    }

    /**
     * 根据传入的客户ID和回访日期，更新客户回访记录
     * @param customerVisit
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping(value = "api/updateCustomerVisit",method = RequestMethod.POST)
    @ResponseBody
    public Error updateCustomerVisit(@RequestBody CustomerVisit customerVisit){
        System.out.println(customerVisit.getContent()+" "+customerVisit.getCustomerId());
        Error error = service.updateCustomerVisit(customerVisit);
        return error;
    }


}
