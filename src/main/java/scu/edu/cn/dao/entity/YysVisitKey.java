package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class YysVisitKey {
    private Integer yysId;

    private Date visitDate;

    public Integer getYysId() {
        return yysId;
    }

    public void setYysId(Integer yysId) {
        this.yysId = yysId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}