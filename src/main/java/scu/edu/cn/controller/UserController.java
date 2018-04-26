package scu.edu.cn.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.UserInfo;
import scu.edu.cn.service.UserService;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Token;

import java.util.List;

import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

@Controller
@RequestMapping("/")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService service;

    /**
     * 获取用户列表
     * @return 用户列表
     */
    @ResponseBody
    @RequestMapping("api/userList")
    public List<UserInfo> getUserList(){
        logger.info("请求获取用户列表");
        List<UserInfo> list = service.selectAllUser();
        if(list == null){
            logger.info("获取用户列表信息失败");
        }
        logger.info("获取用户列表成功");

        return list;
    }

    /**
     * 获取用户页面
     * @return 用户页面
     */
    @RequestMapping("userList")
    public String getUserPage(){
        return "userList.html";
    }

    /**
     * 根据传入的id删除对应的用户
     * @param json 传入的json数据
     * @return 错误信息Error对象
     */
    @RequestMapping(value = "api/deleteUser",method = RequestMethod.POST)
    @ResponseBody
    public Error deleteUser(@RequestBody  String json){
        logger.info("请求删除用户信息");
        Gson gson = new Gson();
        UserInfo info = gson.fromJson(json,UserInfo.class);
        System.out.println(info.getUsername());
        Error error = service.deleteUser(info.getUsername());
        if(error.getCode()==OPERATION_SUCCESS){
            logger.info("删除用户信息成功");
        }else{
            logger.info("删除用户信息失败，{}",error.getMessage());
        }
        return error;
    }

    /**
     * 根据传入的id，批量删除数据
     * @param list 用户列表
     * @return 错误信息Error对象
     */
    @RequestMapping(value = "api/deleteUsers",method = RequestMethod.POST)
    @ResponseBody
    public Error deleteUsers(@RequestBody  UserInfo[]list){
        logger.info("请求批量删除用户信息，{}",list);

        Error error = service.deleteUsers(list);
        if(error.getCode()==OPERATION_SUCCESS){
            logger.info("批量删除用户信息{}成功",list);
        }else{
            logger.info("批量删除用户信息{}失败，{}",error.getMessage());
        }
        return error;
    }

    /**
     * 根据传入的数据添加用户
     * @param json 传入的json数据
     * @return 错误信息Error对象
     */
    @RequestMapping(value = "api/addUser",method = RequestMethod.POST)
    @ResponseBody
    public Error addUser(@RequestBody String json){
        Gson gson = new Gson();
        logger.info("请求插入一条用户信息，{}",json);

        UserInfo info = gson.fromJson(json,UserInfo.class);
        Error error = service.insertUser(info);
        if(error.getCode()==OPERATION_SUCCESS){
            logger.info("插入一条用户信息成功");
        }else{
            logger.info("插入一条用户信息失败，{}",error.getMessage());
        }
        return error;
    }

    /**
     * 根据传入的数据更新用户信息
     * @param json 传入的json数据
     * @return 错误信息Error对象
     */
    @RequestMapping(value = "api/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public Error updateUser(@RequestBody String json){
        Gson gson = new Gson();
        logger.info("请求更新一条用户信息，{}",json);

        UserInfo info = gson.fromJson(json,UserInfo.class);
        info.setToken(new Token().getToken());
        Error error = service.updateUser(info);
        if(error.getCode()==OPERATION_SUCCESS){
            logger.info("更新一条用户信息成功");
        }else{
            logger.info("更新一条用户信息失败，{}",error.getMessage());
        }
        return error;
    }
}
