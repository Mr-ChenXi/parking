package com.qhit.parking.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {

    @Excel(name = "序号",orderNum = "1",isImportField = "true_st",needMerge=true)
    private Integer id;
    @Excel(name = "订单编号",orderNum = "2",isImportField = "true_st",needMerge=true)
    private String code;

    private Integer userId;

    private Integer parkId;
    @Excel(name = "停车时间",orderNum = "6",databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd" ,isImportField = "true_st",needMerge=true)
    private Date createdate;
    @Excel(name = "状态",orderNum = "10",replace = {"订单完成_1,代付款_0"},isImportField = "true_st",needMerge=true)
    private Integer status;
    @Excel(name = "金额",orderNum = "9",isImportField = "true_st",needMerge=true)
    private Double total;

    @Excel(name = "离开时间",orderNum = "7",databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd" ,isImportField = "true_st",needMerge=true)
    private Date enddate;

    @Excel(name = "停车时长",orderNum = "8",isImportField = "true_st",needMerge=true)
    private Integer sumpark;


    @ExcelEntity(id = "id")
    private User user;

    private Park park;

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Orders(Integer id, String code, Integer userId, Integer parkId, Date createdate, Integer status, Double total, Date enddate, Integer sumpark) {
        this.id = id;
        this.code = code;
        this.userId = userId;
        this.parkId = parkId;
        this.createdate = createdate;
        this.status = status;
        this.total = total;
        this.enddate = enddate;
        this.sumpark = sumpark;
    }

    public Orders() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getSumpark() {
        return sumpark;
    }

    public void setSumpark(Integer sumpark) {
        this.sumpark = sumpark;
    }
}