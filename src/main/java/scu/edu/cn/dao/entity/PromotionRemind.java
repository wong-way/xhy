package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PromotionRemind {
    private Integer promotionRemindId;

    private Integer yysId;

    private String yysCurrentLevel;

    private String yysNextLevel;

    private Date yysPromotionalTime;

    public Integer getPromotionRemindId() {
        return promotionRemindId;
    }

    public void setPromotionRemindId(Integer promotionRemindId) {
        this.promotionRemindId = promotionRemindId;
    }

    public Integer getYysId() {
        return yysId;
    }

    public void setYysId(Integer yysId) {
        this.yysId = yysId;
    }

    public String getYysCurrentLevel() {
        return yysCurrentLevel;
    }

    public void setYysCurrentLevel(String yysCurrentLevel) {
        this.yysCurrentLevel = yysCurrentLevel == null ? null : yysCurrentLevel.trim();
    }

    public String getYysNextLevel() {
        return yysNextLevel;
    }

    public void setYysNextLevel(String yysNextLevel) {
        this.yysNextLevel = yysNextLevel == null ? null : yysNextLevel.trim();
    }

    public Date getYysPromotionalTime() {
        return yysPromotionalTime;
    }

    public void setYysPromotionalTime(Date yysPromotionalTime) {
        this.yysPromotionalTime = yysPromotionalTime;
    }
}