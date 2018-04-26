package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

@Component
public class YysEvaluation extends YysEvaluationKey {
    private Double yysSalary;

    private String yysCustomerEvaluation;

    private Integer yysServiceScore;

    public Double getYysSalary() {
        return yysSalary;
    }

    public void setYysSalary(Double yysSalary) {
        this.yysSalary = yysSalary;
    }

    public String getYysCustomerEvaluation() {
        return yysCustomerEvaluation;
    }

    public void setYysCustomerEvaluation(String yysCustomerEvaluation) {
        this.yysCustomerEvaluation = yysCustomerEvaluation == null ? null : yysCustomerEvaluation.trim();
    }

    public Integer getYysServiceScore() {
        return yysServiceScore;
    }

    public void setYysServiceScore(Integer yysServiceScore) {
        this.yysServiceScore = yysServiceScore;
    }
}