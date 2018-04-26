package scu.edu.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.StaffInfo;
import scu.edu.cn.dao.entity.UserInfo;
import scu.edu.cn.dao.mapper.StaffInfoMapper;
import scu.edu.cn.dao.mapper.UserInfoMapper;

/**
 * @authoer 黄伟
 * 测试控制器
 */
@Controller
@RequestMapping(value = "/")
public class TestController {

    @Autowired
    StaffInfoMapper mapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 测试json数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "json", method = RequestMethod.GET)
    public StaffInfo json() {
        StaffInfo info = mapper.selectByPrimaryKey(1);
        return info;
    }

    /**
     * 测试json数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "json2", method = RequestMethod.GET)
    public UserInfo json2() {
        UserInfo info = userInfoMapper.selectByPrimaryKey(1);
        System.out.println(info.getUsername());
        return info;
    }

    /**
     * 测试纯文本
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "string", method = RequestMethod.GET)
    public String string() {
        return "hello world!";
    }

    /**
     * 测试跳转页面
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }

    /**
     * 测试跳转页面
     * @return
     */
    @RequestMapping(value = "index2", method = RequestMethod.GET)
    public String index2() {
        return "index.html";
    }

}
