package com.qhit.parking.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class InPatient implements Serializable {
    private Integer patientId;

    private String patientName;

    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    private String bedNum;

    private Double amount;

    private Integer status;

    private Double  maxAmount;

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    private static final long serialVersionUID = 1L;

    public InPatient(Integer patientId, String patientName, String sex, Date birth, String bedNum, Double amount, Integer status) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.sex = sex;
        this.birth = birth;
        this.bedNum = bedNum;
        this.amount = amount;
        this.status = status;

    }

    public InPatient() {
        super();
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getBedNum() {
        return bedNum;
    }

    public void setBedNum(String bedNum) {
        this.bedNum = bedNum == null ? null : bedNum.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}