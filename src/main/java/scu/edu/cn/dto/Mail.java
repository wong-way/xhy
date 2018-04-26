package scu.edu.cn.dto;

import org.springframework.stereotype.Component;

/**
 * @author 黄伟
 * 用于web与service层之间的数据传输
 */
@Component
public class Mail {
    public String to;
    public String subject;
    public String content;

    public Mail() {
    }

    public Mail(String to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
