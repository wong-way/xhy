package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Receipt {
    private Integer receiptId;

    private Integer contractId;

    private Date realReceivedTime;

    private Integer receivedMoney;

    public Integer getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Integer receiptId) {
        this.receiptId = receiptId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getRealReceivedTime() {
        return realReceivedTime;
    }

    public void setRealReceivedTime(Date realReceivedTime) {
        this.realReceivedTime = realReceivedTime;
    }

    public Integer getReceivedMoney() {
        return receivedMoney;
    }

    public void setReceivedMoney(Integer receivedMoney) {
        this.receivedMoney = receivedMoney;
    }
}