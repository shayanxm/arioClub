package com.example.shayanmoradi.arioclub.model.offers;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Offer {
    @Id(autoincrement = true)
    private Long id;
private Long paientId;
    private String mName;
    private String mPrice;
    private double mAmount;
    private String mDesc;
    @Generated(hash = 1498277236)
    public Offer(Long id, Long paientId, String mName, String mPrice,
            double mAmount, String mDesc) {
        this.id = id;
        this.paientId = paientId;
        this.mName = mName;
        this.mPrice = mPrice;
        this.mAmount = mAmount;
        this.mDesc = mDesc;
    }
    @Generated(hash = 1311880984)
    public Offer() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getPaientId() {
        return this.paientId;
    }
    public void setPaientId(Long paientId) {
        this.paientId = paientId;
    }
    public String getMName() {
        return this.mName;
    }
    public void setMName(String mName) {
        this.mName = mName;
    }
    public String getMPrice() {
        return this.mPrice;
    }
    public void setMPrice(String mPrice) {
        this.mPrice = mPrice;
    }
    public double getMAmount() {
        return this.mAmount;
    }
    public void setMAmount(double mAmount) {
        this.mAmount = mAmount;
    }
    public String getMDesc() {
        return this.mDesc;
    }
    public void setMDesc(String mDesc) {
        this.mDesc = mDesc;
    }

}
