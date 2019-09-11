package com.example.shayanmoradi.arioclub.database;

import android.content.Context;

import com.example.shayanmoradi.arioclub.model.offers.Offer;
import com.example.shayanmoradi.arioclub.model.offers.OfferDao;
import com.example.shayanmoradi.arioclub.model.users.PatientDao;

import java.util.ArrayList;
import java.util.List;

public class OfferLab {
    public static OfferLab instance;
    private Context mContext;

    private DaoSession daoSession = App.getApp().getDaoSession();
    private OfferDao detailsDao = daoSession.getOfferDao();

    private OfferLab(Context context) {
        mContext = context.getApplicationContext();

    }

    private OfferLab() {


    }
    public static OfferLab getInstance(Context context) {
        if (instance == null)
            instance = new OfferLab(context);
        return instance;
    }
    public static OfferLab getInstance() {
        if (instance == null)
            instance = new OfferLab();
        return instance;
    }

    public Offer getDetail(String phoneNumber, String passWord) {


        List<Offer> offers = detailsDao.queryBuilder()
                .where(PatientDao.Properties.MPhoneNumber.eq(phoneNumber))
                .where(PatientDao.Properties.Password.eq(passWord))
                .list();
        for (Offer offer : offers) {
            return offer;
        }
        return null;
    }
//    public List<Offer>getAllOffers(){
//        List<Offer> offers = detailsDao.queryBuilder()
//                .list();
//        return offers;
//    }
//

    public List<Offer> getAllOffers() {
        List<Offer>temp= new ArrayList<>();
        List<Offer> offers = detailsDao.queryBuilder()
//        List<Address> addressList = detailsDao.queryBuilder()
                .where(OfferDao.Properties.PaientId.isNull())

                .list();
        for (Offer offer : offers) {
            temp.add(offer);
        }
        return offers;
    }

    public List<Offer> getPaientBag(Long paietnId) {
        List<Offer>temp= new ArrayList<>();
        List<Offer> offers = detailsDao.queryBuilder()
//        List<Address> addressList = detailsDao.queryBuilder()
                .where(OfferDao.Properties.PaientId.eq(paietnId))

                .list();
        for (Offer offer : offers) {
            temp.add(offer);
        }
        return offers;
    }



    public void createBasicOffer (Offer patient){
        detailsDao.insert(patient);
    }

    public void userBuysOffer (Offer patient){
        detailsDao.insert(patient);
    }

    public void update (Offer patient){
        detailsDao.update(patient);
    }
    public void delete (Offer patient){
        detailsDao.delete(patient);
    }
}
