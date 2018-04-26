package scu.edu.cn.dto;

public class Summary {
    Integer userCount ;
    Integer customerCount;
    Integer receiptCount;
    Integer visitCount;

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(Integer customerCount) {
        this.customerCount = customerCount;
    }

    public Integer getReceiptCount() {
        return receiptCount;
    }

    public void setReceiptCount(Integer receiptCount) {
        this.receiptCount = receiptCount;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public Summary(Integer userCount, Integer customerCount, Integer receiptCount, Integer visitCount) {
        this.userCount = userCount;
        this.customerCount = customerCount;
        this.receiptCount = receiptCount;
        this.visitCount = visitCount;
    }
}
