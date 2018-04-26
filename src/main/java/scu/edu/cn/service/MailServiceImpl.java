package scu.edu.cn.service;


import org.springframework.stereotype.Service;
import scu.edu.cn.dto.Mail;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.MailUtil;

import static scu.edu.cn.util.Constant.*;
@Service
public class MailServiceImpl implements MailService {
    @Override
    public Error sendMail(Mail mail) {
        Error error;
        MailUtil util = new MailUtil();
        try {
            util.sendMail(mail.getTo(), mail.getSubject(), mail.getContent());
            error = new Error(OPERATION_SUCCESS, "发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "发送异常");
        }
        return  error;

    }
}
