package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

@Component
public class CustomerVisit extends CustomerVisitKey {
    private Integer staffId;

    private String content;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}