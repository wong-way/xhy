package scu.edu.cn.controller;
/**
 * 处理顾客信息相关操作
 *
 * @author 黄伟
 */

import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.CustomerInfo;
import scu.edu.cn.service.CustomerService;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import javax.servlet.http.HttpSession;
import java.util.List;

import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

@Controller
@RequestMapping("/")
public class CustomerController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CustomerService service;

    /**
     * API接口获取顾客列表
     *
     * @return 包含顾客信息的列表
     */
    @ResponseBody
    @RequestMapping("api/customerList")
    public List<CustomerInfo> getList() {
        logger.info("请求获取所有的顾客信息");
        Response response = service.getAllCustomer();
        if (response.getError().getCode() == OPERATION_SUCCESS)
        {
            logger.info("请求获取所有的顾客信息成功");
            return (List<CustomerInfo>) response.getData();
        }
        else{
            logger.info("请求获取所有的顾客信息失败,{}",response.getError().getMessage());
        }
            return null;
    }

    /**
     * 获取顾客信息列表
     *
     * @return 返回顾客信息页面
     */

    @RequestMapping("customerList")
    public String getCustomerPage() {
        return "customerList.html";
    }

    /**
     * 获取编辑顾客页面
     *
     * @return 便捷顾客页面
     */
    @RequestMapping("editCustomer")
    public String editCustomerPage() {
        return "editCustomer.html";
    }

    /**
     * 根据传入的id获取对应的页面
     *
     * @param session    会话信息
     * @param customerId 顾客的id
     * @return 编辑页面
     */
    @RequestMapping(value = "updateCustomer/{id}")
    public String updateCustomerPage(HttpSession session, @PathVariable("id") int customerId) {
        logger.info("请求更新id为{}顾客信息",customerId);
        session.setAttribute("customerId", customerId);
        return "editCustomer.html";
    }

    /**
     * 删除顾客信息的API接口
     *
     * @param customerId 顾客id
     * @return Error类包含错误信息
     */
    @ResponseBody
    @RequestMapping("api/deleteCustomer")
    public Error deleteCustomer(@RequestParam("customerId") Integer customerId) {
        logger.info("请求删除id为{}顾客信息",customerId);
        Error error = service.deleteCustomerById(customerId);
        if(error.getCode()==OPERATION_SUCCESS){
            logger.info("删除id为{}顾客信息成功",customerId);
        }else{
            logger.info("删除id为{}顾客信息失败,{}",customerId,error.getMessage());
        }

        return error;
    }

    /**
     * 批量删除顾客信息的API接口
     * @param list 顾客信息数组
     * @return Error类包含错误信息
     */
    @ResponseBody
    @RequestMapping("api/deleteCustomers")
    public Error deleteAllCustomer(@RequestBody CustomerInfo[] list) {
        logger.info("请求批量删除顾客信息,{}",list);

        Error error = service.deleteCustomers(list);
        if(error.getCode()==OPERATION_SUCCESS){
            logger.info("批量删除信息成功");

        }else{
            logger.info("批量删除信息失败,{}",error.getMessage());
        }
        return error;
    }

    /**
     * 编辑顾客信息的API接口
     * @param info json数据
     * @param session 会话信息
     * @return Error类的控制信息
     */
    @ResponseBody
    @RequestMapping("api/editCustomer")
    public Error addCustomer(@RequestBody String info, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        CustomerInfo customer;
        Gson gson = new Gson();
        Error error;
        customer = gson.fromJson(info, CustomerInfo.class);
        System.out.println(info);
        if (customerId == null)
        {
            logger.info("请求向数据库插入一条新的数据");
            error = service.insertCustomer(customer);
        }
        else {
            customer.setCustomerId(customerId);
            logger.info("请求向数据库更新一条已有的数据");
            error = service.updateCustomer(customer);

        }
        if(error.getCode()==OPERATION_SUCCESS){
            logger.info("操作成功");
        }else{
            logger.info("操作失败，{}",error.getMessage());
        }
        return error;
    }

    /**
     * 获取顾客信息
     * @param session 会话信息
     * @return 对应的顾客信息
     */
    @ResponseBody
    @RequestMapping("api/getCustomer")
    public CustomerInfo getCustomer(HttpSession session){
        Integer customerId =(Integer) session.getAttribute("customerId");
        session.removeAttribute("customerId");
        Response response = service.getCustomer(customerId);
        logger.info("请求获取数据库信息");
        if (response.getError().getCode() == OPERATION_SUCCESS) {
            logger.info("获取数据库信息成功");
            return (CustomerInfo)response.getData();
        }else{
            logger.info("获取数据库信息失败,{}",response.getError().getMessage());
            return null;
        }
    }

    /**
     * 插入顾客的API接口
     * @param info json数据
     * @return Error类包含错误信息和状态码
     */
    @ResponseBody
    @RequestMapping("api/insertCustomer")
    public Error updateCustomer(@RequestBody String info) {
        CustomerInfo customer;
        Gson gson = new Gson();
        Error error;
        customer = gson.fromJson(info, CustomerInfo.class);
        logger.info("请求向数据库插入一条新的数据");
        error = service.insertCustomer(customer);
        if(error.getCode()==OPERATION_SUCCESS){
            logger.info("插入数据成功");
        }else{
            logger.info("插入数据失败，{}",error.getMessage());
        }
        return error;
    }
}
