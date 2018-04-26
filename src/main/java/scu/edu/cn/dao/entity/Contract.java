package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Contract {
    private Integer contractId;

    private Date contractCollectionTime;

    private Double contractAmount;

    private Integer customerId;

    private String contractServiceContent;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getContractCollectionTime() {
        return contractCollectionTime;
    }

    public void setContractCollectionTime(Date contractCollectionTime) {
        this.contractCollectionTime = contractCollectionTime;
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getContractServiceContent() {
        return contractServiceContent;
    }

    public void setContractServiceContent(String contractServiceContent) {
        this.contractServiceContent = contractServiceContent == null ? null : contractServiceContent.trim();
    }
}