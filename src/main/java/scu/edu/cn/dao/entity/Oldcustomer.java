package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Oldcustomer {
    private Integer customerId;

    private Date contractTime;

    private String requiredRequirements;

    private String babyBasicInformation;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getContractTime() {
        return contractTime;
    }

    public void setContractTime(Date contractTime) {
        this.contractTime = contractTime;
    }

    public String getRequiredRequirements() {
        return requiredRequirements;
    }

    public void setRequiredRequirements(String requiredRequirements) {
        this.requiredRequirements = requiredRequirements == null ? null : requiredRequirements.trim();
    }

    public String getBabyBasicInformation() {
        return babyBasicInformation;
    }

    public void setBabyBasicInformation(String babyBasicInformation) {
        this.babyBasicInformation = babyBasicInformation == null ? null : babyBasicInformation.trim();
    }
}