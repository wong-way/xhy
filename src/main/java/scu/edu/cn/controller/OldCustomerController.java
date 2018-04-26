package scu.edu.cn.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.Oldcustomer;
import scu.edu.cn.service.OldCustomerService;
import scu.edu.cn.util.Error;

import java.util.List;

@Controller
@RequestMapping("/")
public class OldCustomerController {

    @Autowired
    OldCustomerService oldCustomerService;

    /**
     * 添加老客户记录
     * @param json
     * @return
     */
    @RequestMapping(value = "api/addOldCustomer",method = RequestMethod.POST)
    @ResponseBody
    public Error addOldCustomer(@RequestBody Oldcustomer json){
//        Gson gson = new Gson();
//        Oldcustomer oldcustomer = gson.fromJson(json,Oldcustomer.class);
        Error error = oldCustomerService.insertOldCustomer(json);
        return error;
    }

    /**
     * 查找老客户记录
     * @param json
     * @return
     */
    @RequestMapping(value = "api/selectOldCustomer",method = RequestMethod.POST)
    @ResponseBody
    public Error selectOldCustomer(@RequestBody String json){
        Gson gson = new Gson();
        Oldcustomer oldcustomer = gson.fromJson(json,Oldcustomer.class);
        Error error = oldCustomerService.selectOldCustomerById(oldcustomer.getCustomerId()).getError();
        return error;
    }

    /**
     * 删除老客户记录
     * @param json
     * @return
     */
    @RequestMapping(value = "api/deleteOldCustomer",method = RequestMethod.POST)
    @ResponseBody
    public Error deleteOldCustomer(@RequestParam("customerId") Integer json){
  //      System.out.println(json);
//        Gson gson = new Gson();
//        Oldcustomer oldcustomer = gson.fromJson(json,Oldcustomer.class);
//        System.out.println(oldcustomer.getCustomerId());
        Error error = oldCustomerService.deleteOldCustomer(json);
        return error;
    }

    /**
     * 更新老客户记录
     * @param json
     * @return
     */
    @RequestMapping(value = "api/updateOldCustomer",method = RequestMethod.POST)
    @ResponseBody
    public Error updateOldCustomer(@RequestBody Oldcustomer json){
//        Gson gson = new Gson();
//        System.out.println(json);
//        Oldcustomer oldcustomer = gson.fromJson(json.toString(),Oldcustomer.class);
        //info.setToken(new Token().getToken());
        Error error = oldCustomerService.updateOldCustomer(json);
        return error;
    }

    /**
     * 查看老客户记录，返回页面
     * @return
     */
    @RequestMapping("oldCustomerList")
    public String getOldCustomer(){
        return "oldCustomerList.html";
    }

    /**
     * 查找所有老客户记录
     * @return
     */
    @ResponseBody
    @RequestMapping("api/oldCustomerList")
    public List<Oldcustomer> getOldCustomerList(){
        List<Oldcustomer> list = oldCustomerService.selectAllOldCustomer();
        return list;
    }


}
