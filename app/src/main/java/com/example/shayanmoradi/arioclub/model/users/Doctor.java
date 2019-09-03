package com.example.shayanmoradi.arioclub.model.users;

public class Doctor extends User {
    UserType user= UserType.doctor;

    public Doctor(String mName, String mFamily, String mNationalCode, String mPhoneNumber, String mEmail, String mAddrees, UserType user) {
        super(mName, mFamily, mNationalCode, mPhoneNumber, mEmail, mAddrees);
        this.user = user;
    }
}
