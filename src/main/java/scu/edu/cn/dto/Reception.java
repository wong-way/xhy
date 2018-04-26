package scu.edu.cn.dto;

import java.util.Date;

public class Reception {

    private String customerName;

    private String customerContact;

    private String requiredRequirements;

    private Integer staffId;

    private Integer mode;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getRequiredRequirements() {
        return requiredRequirements;
    }

    public void setRequiredRequirements(String requiredRequirements) {
        this.requiredRequirements = requiredRequirements;
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

    public Reception(String customerName, String customerContact, String requiredRequirements, Integer staffId, Integer mode) {
        this.customerName = customerName;

        this.customerContact = customerContact;
        this.requiredRequirements = requiredRequirements;
        this.staffId = staffId;
        this.mode = mode;
    }
}
