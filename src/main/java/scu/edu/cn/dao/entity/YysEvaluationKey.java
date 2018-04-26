package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

@Component
public class YysEvaluationKey {
    private Integer yysId;

    private Integer contractId;

    public Integer getYysId() {
        return yysId;
    }

    public void setYysId(Integer yysId) {
        this.yysId = yysId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }
}