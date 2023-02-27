package com.jwan.domain;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.TypeDiscriminator;

public class Fruit {


    private Integer fId;

    private String  fName;

    private Integer fPrice;

    private Integer fCount;

    private String fRemark;

    public Fruit() {
    }

    public Fruit(Integer fId, String fName, Integer fPrice, Integer fCount, String fRemark) {
        this.fId = fId;
        this.fName = fName;
        this.fPrice = fPrice;
        this.fCount = fCount;
        this.fRemark = fRemark;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "fId=" + fId +
                ", fName='" + fName + '\'' +
                ", fPrice=" + fPrice +
                ", fCount=" + fCount +
                ", fRemark='" + fRemark + '\'' +
                '}';
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Integer getfPrice() {
        return fPrice;
    }

    public void setfPrice(Integer fPrice) {
        this.fPrice = fPrice;
    }

    public Integer getfCount() {
        return fCount;
    }

    public void setfCount(Integer fCount) {
        this.fCount = fCount;
    }

    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark;
    }
}
