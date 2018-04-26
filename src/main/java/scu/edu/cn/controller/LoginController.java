package scu.edu.cn.controller;

import com.google.gson.Gson;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.UserInfo;
import scu.edu.cn.service.UserService;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Token;
import scu.edu.cn.service.LoginService;

import javax.servlet.http.HttpSession;

import static scu.edu.cn.util.Constant.LOGIN_SUCCESS;
import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

/**
 * @author 黄伟
 * 处理登录相关操作
 */
@Controller
@RequestMapping("/")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginService service;
    @Autowired
    UserService userService;

    /**
     * 返回登录界面
     *
     * @return
     */
    @RequestMapping(value = "login1", method = RequestMethod.GET)
    public String login1() {
        return "login.jsp";

    }

    /**
     * 返回登录界面
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login.html";

    }

    /**
     * 登陆接口
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Error doLogin(HttpSession session, @Param("username") String username, @Param("password") String password) {
        Token token = new Token();
        UserInfo info = new UserInfo();
        logger.info("用户-{}请求登陆", username);
        info.setUsername(username);
        info.setPassword(password);
        info.setToken(token.getToken());
        Error error = service.login(info);
        if (error.getCode() == LOGIN_SUCCESS) {
            logger.info("用户-{}登陆成功", username);
            session.setAttribute("token", token.getToken());
            session.setAttribute("username", username);
        }else {
            logger.info("用户-{}登陆失败，{}", username, error.getMessage());
        }
        return error;
    }

    /**
     * 备用登陆接口
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "login1", method = RequestMethod.POST)
    public String doLogin1(HttpSession session, Model model, @Param("username") String username, @Param("password") String password) {
        Token token = new Token();
        UserInfo info = new UserInfo();
        info.setUsername(username);
        info.setPassword(password);
        info.setToken(token.getToken());
        logger.info("用户-{}请求登陆", username);
        Error error = service.login(info);
        if (error.getCode() == LOGIN_SUCCESS) {
            logger.info("用户-{}登陆成功", username);
            session.setAttribute("token", token.getToken());
            session.setAttribute("username", username);
            return "redirect:index";
        } else {
            logger.info("用户-{}登陆失败，{}", username, error.getMessage());
            model.addAttribute("error", error.getMessage());
            return "login.jsp";
        }
    }

    /**
     * 跳转主页
     *
     * @return 跳转主页
     */
    @RequestMapping(value = "index")
    public String index() {
        return "index.html";
    }


    /**
     * 用户退出 清除session
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "logout")
    public String logout(HttpSession session) {
        logger.info("用户-{}登陆失败，{}", session.getAttribute("username"));
        session.invalidate();
        return "redirect:login";
    }

    /**
     * 返回注册的页面
     *
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register.html";
    }

    /**
     * 注册的接口
     *
     * @param json
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public Error doRegister(@RequestBody String json) {
        System.out.println(json);
        Gson gson = new Gson();
        UserInfo info = gson.fromJson(json, UserInfo.class);
        info.setIsAdmin(false);
        logger.info("用户-{}请求注册", info.getUsername());
        Error error = userService.insertUser(info);
        if (error.getCode() == OPERATION_SUCCESS) {
            logger.info("用户-{}注册成功", info.getUsername());
        } else {
            logger.info("用户-{}注册失败,{}", info.getUsername(), error.getMessage());
        }
        return error;
    }
}
