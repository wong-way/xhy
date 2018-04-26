package scu.edu.cn.dto;

import java.util.Date;

public class BriefRecord {
    public Date date;
    public String customerName;
    public String content;
    public String staffName;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public BriefRecord(Date date, String customerName, String content, String staffName) {
        this.date = date;

        this.customerName = customerName;
        this.content = content;
        this.staffName = staffName;
    }
}
