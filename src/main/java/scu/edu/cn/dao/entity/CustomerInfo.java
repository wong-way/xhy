package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class CustomerInfo {
    private Integer customerId;

    private String customerName;

    private String customerPhone;

    private Date customerExpectedDate;

    public String getCustomerExpectedDateTxt() {
        if(this.getCustomerExpectedDate()!=null){
            return  "2018-3-23 09:42:00";

        }
        return null;
    }

    private String customerExpectedDateTxt;


    private Date customerDemandDate;

    private String customerDemandService;

    private String customerAddress;

    private Integer staffId;

    private Integer yysId;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    public Date getCustomerExpectedDate() {
        return customerExpectedDate;
    }

    public void setCustomerExpectedDate(Date customerExpectedDate) {
        this.customerExpectedDate = customerExpectedDate;
    }

    public Date getCustomerDemandDate() {
        return customerDemandDate;
    }

    public void setCustomerDemandDate(Date customerDemandDate) {
        this.customerDemandDate = customerDemandDate;
    }

    public String getCustomerDemandService() {
        return customerDemandService;
    }

    public void setCustomerDemandService(String customerDemandService) {
        this.customerDemandService = customerDemandService == null ? null : customerDemandService.trim();
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress == null ? null : customerAddress.trim();
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getYysId() {
        return yysId;
    }

    public void setYysId(Integer yysId) {
        this.yysId = yysId;
    }
}