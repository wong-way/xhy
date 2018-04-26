package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

@Component
public class YysInfo {
    private Integer yysId;

    private String yysName;

    private String yysPhoto;

    private Integer yysAge;

    private String yysConstellation;

    private String yysEducation;

    private Boolean yysMarriage;

    private String yysCertificate;

    private String yysRecommendedReason;

    public Integer getYysId() {
        return yysId;
    }

    public void setYysId(Integer yysId) {
        this.yysId = yysId;
    }

    public String getYysName() {
        return yysName;
    }

    public void setYysName(String yysName) {
        this.yysName = yysName == null ? null : yysName.trim();
    }

    public String getYysPhoto() {
        return yysPhoto;
    }

    public void setYysPhoto(String yysPhoto) {
        this.yysPhoto = yysPhoto == null ? null : yysPhoto.trim();
    }

    public Integer getYysAge() {
        return yysAge;
    }

    public void setYysAge(Integer yysAge) {
        this.yysAge = yysAge;
    }

    public String getYysConstellation() {
        return yysConstellation;
    }

    public void setYysConstellation(String yysConstellation) {
        this.yysConstellation = yysConstellation == null ? null : yysConstellation.trim();
    }

    public String getYysEducation() {
        return yysEducation;
    }

    public void setYysEducation(String yysEducation) {
        this.yysEducation = yysEducation == null ? null : yysEducation.trim();
    }

    public Boolean getYysMarriage() {
        return yysMarriage;
    }

    public void setYysMarriage(Boolean yysMarriage) {
        this.yysMarriage = yysMarriage;
    }

    public String getYysCertificate() {
        return yysCertificate;
    }

    public void setYysCertificate(String yysCertificate) {
        this.yysCertificate = yysCertificate == null ? null : yysCertificate.trim();
    }

    public String getYysRecommendedReason() {
        return yysRecommendedReason;
    }

    public void setYysRecommendedReason(String yysRecommendedReason) {
        this.yysRecommendedReason = yysRecommendedReason == null ? null : yysRecommendedReason.trim();
    }
}