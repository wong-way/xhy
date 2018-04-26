package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

@Component
public class YysExperience {
    private Integer yysExperienceId;

    private String yysWorkTime;

    private String yysCustomerEvaluation;

    private Integer yysId;

    private String yysWorkContent;

    public Integer getYysExperienceId() {
        return yysExperienceId;
    }

    public void setYysExperienceId(Integer yysExperienceId) {
        this.yysExperienceId = yysExperienceId;
    }

    public String getYysWorkTime() {
        return yysWorkTime;
    }

    public void setYysWorkTime(String yysWorkTime) {
        this.yysWorkTime = yysWorkTime == null ? null : yysWorkTime.trim();
    }

    public String getYysCustomerEvaluation() {
        return yysCustomerEvaluation;
    }

    public void setYysCustomerEvaluation(String yysCustomerEvaluation) {
        this.yysCustomerEvaluation = yysCustomerEvaluation == null ? null : yysCustomerEvaluation.trim();
    }

    public Integer getYysId() {
        return yysId;
    }

    public void setYysId(Integer yysId) {
        this.yysId = yysId;
    }

    public String getYysWorkContent() {
        return yysWorkContent;
    }

    public void setYysWorkContent(String yysWorkContent) {
        this.yysWorkContent = yysWorkContent == null ? null : yysWorkContent.trim();
    }
}