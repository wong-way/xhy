package scu.edu.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    /**
     * 请求主页
     * @return 主页页面
     */
    @RequestMapping("")
    public String mainPage(){
        return "main.html";
    }

    /**
     * 获取联系我们页面
     * @return 联系页面
     */
    @RequestMapping("/contact")
    public String contactPage(){
        return "contact.html";
    }


}
