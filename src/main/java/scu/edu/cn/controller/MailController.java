package scu.edu.cn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import scu.edu.cn.dto.Mail;
import scu.edu.cn.service.MailService;
import scu.edu.cn.util.Error;

import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

/**
 * @author 黄伟
 * 处理邮件相关
 */
@Controller
@RequestMapping("/")
public class MailController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MailService service ;

    /**
     * 传入Mail对象 发送邮件
     * @param mail Mail对象
     * @return Error类包含错误信息
     */
    @ResponseBody
    @RequestMapping("sendEmail")
    public Error sendEmail(@RequestBody  Mail mail) {
        logger.info("请求发送邮件-{}",mail);
        Error error=service.sendMail(mail);
        if(error.getCode()==OPERATION_SUCCESS){
            logger.info("发送邮件成功");
        }else{
            logger.info("发送邮件失败，{}",error.getMessage());
        }
        return error;
    }

    /**
     * 返回发送邮件界面
     * @return 发送邮件界面
     */
    @RequestMapping("mail")
    public String mailPage() {
        return "mail.html";
    }

}
