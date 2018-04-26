package scu.edu.cn.service;

import scu.edu.cn.dto.Mail;
import scu.edu.cn.util.Error;

/**
 * @author 黄伟
 * 处理发送邮件相关业务
 */
public interface MailService {
    /**
     * 发送邮件
     * @param mail Mail对象
     * @return Error类
     */
    Error sendMail(Mail mail);
}
