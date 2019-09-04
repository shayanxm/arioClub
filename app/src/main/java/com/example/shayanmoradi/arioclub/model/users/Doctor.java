package com.example.shayanmoradi.arioclub.model.users;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class Doctor  {
    @Id(autoincrement = true)
    private Long id;
    private String mName;
    private String mFamily;
    private String mNationalCode;
    private String mPhoneNumber;
    private String mEmail;
    private String mAddrees;
    private String password;
    String name;
    @Generated(hash = 442893014)
    public Doctor(Long id, String mName, String mFamily, String mNationalCode,
            String mPhoneNumber, String mEmail, String mAddrees, String password,
            String name) {
        this.id = id;
        this.mName = mName;
        this.mFamily = mFamily;
        this.mNationalCode = mNationalCode;
        this.mPhoneNumber = mPhoneNumber;
        this.mEmail = mEmail;
        this.mAddrees = mAddrees;
        this.password = password;
        this.name = name;
    }
    @Generated(hash = 73626718)
    public Doctor() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMName() {
        return this.mName;
    }
    public void setMName(String mName) {
        this.mName = mName;
    }
    public String getMFamily() {
        return this.mFamily;
    }
    public void setMFamily(String mFamily) {
        this.mFamily = mFamily;
    }
    public String getMNationalCode() {
        return this.mNationalCode;
    }
    public void setMNationalCode(String mNationalCode) {
        this.mNationalCode = mNationalCode;
    }
    public String getMPhoneNumber() {
        return this.mPhoneNumber;
    }
    public void setMPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }
    public String getMEmail() {
        return this.mEmail;
    }
    public void setMEmail(String mEmail) {
        this.mEmail = mEmail;
    }
    public String getMAddrees() {
        return this.mAddrees;
    }
    public void setMAddrees(String mAddrees) {
        this.mAddrees = mAddrees;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



}
