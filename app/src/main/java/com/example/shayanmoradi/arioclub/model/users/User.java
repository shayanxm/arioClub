package com.example.shayanmoradi.arioclub.model.users;

public class User {
    private String mName;
    private String mFamily;
    private String mNationalCode;
    private String mPhoneNumber;
    private String mEmail;
    private String mAddrees;


    public User(String mName, String mFamily, String mNationalCode, String mPhoneNumber, String mEmail, String mAddrees) {
        this.mName = mName;
        this.mFamily = mFamily;
        this.mNationalCode = mNationalCode;
        this.mPhoneNumber = mPhoneNumber;
        this.mEmail = mEmail;
        this.mAddrees = mAddrees;
    }
}
