package scu.edu.cn.dao.entity;

import org.springframework.stereotype.Component;

@Component
public class StaffInfo {
    private Integer staffId;

    private Integer staffAge;

    private String staffName;

    private String staffPhoto;

    private String staffPosition;

    private String staffConstellation;

    private String staffEducation;

    private String staffCertificates;

    private String staffLevel;

    private Boolean staffDutyOn;

    private Boolean staffMarriage;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffPhoto() {
        return staffPhoto;
    }

    public void setStaffPhoto(String staffPhoto) {
        this.staffPhoto = staffPhoto == null ? null : staffPhoto.trim();
    }

    public String getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(String staffPosition) {
        this.staffPosition = staffPosition == null ? null : staffPosition.trim();
    }

    public String getStaffConstellation() {
        return staffConstellation;
    }

    public void setStaffConstellation(String staffConstellation) {
        this.staffConstellation = staffConstellation == null ? null : staffConstellation.trim();
    }

    public String getStaffEducation() {
        return staffEducation;
    }

    public void setStaffEducation(String staffEducation) {
        this.staffEducation = staffEducation == null ? null : staffEducation.trim();
    }

    public String getStaffCertificates() {
        return staffCertificates;
    }

    public void setStaffCertificates(String staffCertificates) {
        this.staffCertificates = staffCertificates == null ? null : staffCertificates.trim();
    }

    public String getStaffLevel() {
        return staffLevel;
    }

    public void setStaffLevel(String staffLevel) {
        this.staffLevel = staffLevel == null ? null : staffLevel.trim();
    }

    public Boolean getStaffDutyOn() {
        return staffDutyOn;
    }

    public void setStaffDutyOn(Boolean staffDutyOn) {
        this.staffDutyOn = staffDutyOn;
    }

    public Boolean getStaffMarriage() {
        return staffMarriage;
    }

    public void setStaffMarriage(Boolean staffMarriage) {
        this.staffMarriage = staffMarriage;
    }
}