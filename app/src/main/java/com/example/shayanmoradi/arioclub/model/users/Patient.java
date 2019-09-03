package com.example.shayanmoradi.arioclub.model.users;

import com.example.shayanmoradi.arioclub.model.offers.Offers;

import java.util.List;

public class Patient extends User {
private List<Offers>mOfferList;
    public Patient(String mName, String mFamily, String mNationalCode, String mPhoneNumber, String mEmail, String mAddrees) {
        super(mName, mFamily, mNationalCode, mPhoneNumber, mEmail, mAddrees);
    }

}
