package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

@Component
public class YysVisit extends YysVisitKey {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}