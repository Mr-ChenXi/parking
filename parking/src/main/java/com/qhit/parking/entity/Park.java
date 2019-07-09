package com.qhit.parking.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

public class Park implements Serializable {

    private Integer id;
    @Excel(name = "车位名称",orderNum = "1",isImportField = "true_st",needMerge=true)
    private String name;

    @Excel(name = "车位价格",orderNum = "2",isImportField = "true_st",needMerge=true)
    private Double price;

    @Excel(name = "车位状态",orderNum = "3",replace = {"已预约_1,空置_0"},isImportField = "true_st",needMerge=true)
    private Integer status;

    @Excel(name = "车位地址",orderNum = "4",isImportField = "true_st",needMerge=true)
    private String parkaddr;

    private static final long serialVersionUID = 1L;

    public Park(Integer id, String name, Double price, Integer status, String parkaddr) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.parkaddr = parkaddr;
    }

    public Park() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getParkaddr() {
        return parkaddr;
    }

    public void setParkaddr(String parkaddr) {
        this.parkaddr = parkaddr == null ? null : parkaddr.trim();
    }
}