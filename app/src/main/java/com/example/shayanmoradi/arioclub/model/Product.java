package com.example.shayanmoradi.arioclub.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class Product {
    @Id(autoincrement = true)
    private Long id;
    private String mNAme;
 private   String mCode;
    private Double mPrice;
    private Long mPatientId;
    @Generated(hash = 2081346157)
    public Product(Long id, String mNAme, String mCode, Double mPrice,
            Long mPatientId) {
        this.id = id;
        this.mNAme = mNAme;
        this.mCode = mCode;
        this.mPrice = mPrice;
        this.mPatientId = mPatientId;
    }
    @Generated(hash = 1890278724)
    public Product() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMNAme() {
        return this.mNAme;
    }
    public void setMNAme(String mNAme) {
        this.mNAme = mNAme;
    }
    public String getMCode() {
        return this.mCode;
    }
    public void setMCode(String mCode) {
        this.mCode = mCode;
    }
    public Double getMPrice() {
        return this.mPrice;
    }
    public void setMPrice(Double mPrice) {
        this.mPrice = mPrice;
    }
    public Long getMPatientId() {
        return this.mPatientId;
    }
    public void setMPatientId(Long mPatientId) {
        this.mPatientId = mPatientId;
    }
}
