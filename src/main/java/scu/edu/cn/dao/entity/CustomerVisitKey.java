package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomerVisitKey {
    private Integer customerId;

    private Date visitDate;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}