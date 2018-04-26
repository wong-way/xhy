package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PromotionRecord {
    private Integer promotionRecordId;

    private Integer yysId;

    private String yysPreviousLevel;

    private String yysCurrentLevel;

    private Date yysPromotionTime;

    public Integer getPromotionRecordId() {
        return promotionRecordId;
    }

    public void setPromotionRecordId(Integer promotionRecordId) {
        this.promotionRecordId = promotionRecordId;
    }

    public Integer getYysId() {
        return yysId;
    }

    public void setYysId(Integer yysId) {
        this.yysId = yysId;
    }

    public String getYysPreviousLevel() {
        return yysPreviousLevel;
    }

    public void setYysPreviousLevel(String yysPreviousLevel) {
        this.yysPreviousLevel = yysPreviousLevel == null ? null : yysPreviousLevel.trim();
    }

    public String getYysCurrentLevel() {
        return yysCurrentLevel;
    }

    public void setYysCurrentLevel(String yysCurrentLevel) {
        this.yysCurrentLevel = yysCurrentLevel == null ? null : yysCurrentLevel.trim();
    }

    public Date getYysPromotionTime() {
        return yysPromotionTime;
    }

    public void setYysPromotionTime(Date yysPromotionTime) {
        this.yysPromotionTime = yysPromotionTime;
    }
}