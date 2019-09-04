package com.example.shayanmoradi.arioclub.model.users;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class Admin  {
    @Id(autoincrement = true)
    private Long id;
    private String mName;
    private String mFamily;
    private String mNationalCode;
    private String mPhoneNumber;
    private String mEmail;
    private String mAddrees;
    @Generated(hash = 1139452151)
    public Admin(Long id, String mName, String mFamily, String mNationalCode,
            String mPhoneNumber, String mEmail, String mAddrees) {
        this.id = id;
        this.mName = mName;
        this.mFamily = mFamily;
        this.mNationalCode = mNationalCode;
        this.mPhoneNumber = mPhoneNumber;
        this.mEmail = mEmail;
        this.mAddrees = mAddrees;
    }
    @Generated(hash = 1708792177)
    public Admin() {
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
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }


}
