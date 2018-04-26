package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ReceptionSituation {
    private Integer receptionId;

    private String customerName;

    private String customerContact;

    private String customerAddress;

    private String requiredRequirements;

    private Date requiredTime;

    private String content;

    private Integer staffId;

    private Integer mode;

    public Integer getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(Integer receptionId) {
        this.receptionId = receptionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact == null ? null : customerContact.trim();
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress == null ? null : customerAddress.trim();
    }

    public String getRequiredRequirements() {
        return requiredRequirements;
    }

    public void setRequiredRequirements(String requiredRequirements) {
        this.requiredRequirements = requiredRequirements == null ? null : requiredRequirements.trim();
    }

    public Date getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(Date requiredTime) {
        this.requiredTime = requiredTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }
}