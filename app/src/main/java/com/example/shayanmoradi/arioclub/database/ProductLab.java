package com.example.shayanmoradi.arioclub.database;

import android.content.Context;

import com.example.shayanmoradi.arioclub.model.Product;
import com.example.shayanmoradi.arioclub.model.ProductDao;

import java.util.ArrayList;
import java.util.List;

public class ProductLab {
    public static ProductLab instance;
    private Context mContext;

    private DaoSession daoSession = App.getApp().getDaoSession();
    private ProductDao detailsDao = daoSession.getProductDao();

    private ProductLab(Context context) {
        mContext = context.getApplicationContext();

    }

    private ProductLab() {


    }
    public static ProductLab getInstance(Context context) {
        if (instance == null)
            instance = new ProductLab(context);
        return instance;
    }
    public static ProductLab getInstance() {
        if (instance == null)
            instance = new ProductLab();
        return instance;
    }

    public Product getDetail(String productCode) {


        List<Product> offers = detailsDao.queryBuilder()
                .where(ProductDao.Properties.MCode.eq(productCode))

                .list();
        for (Product offer : offers) {
            return offer;
        }
        return null;
    }
    public List<Product>getAllProducts(){
        List<Product> offers = detailsDao.queryBuilder()
                .list();
        return offers;
    }


    public List<Product> getAllNullProducts() {
        List<Product>temp= new ArrayList<>();
        List<Product> offers = detailsDao.queryBuilder()
//        List<Address> addressList = detailsDao.queryBuilder()
                .where(ProductDao.Properties.MPatientId.isNull())

                .list();
        for (Product offer : offers) {
            temp.add(offer);
        }
        return offers;
    }

    public List<Product> getPaientProducts(Long paietnId) {
        List<Product>temp= new ArrayList<>();
        List<Product> offers = detailsDao.queryBuilder()
//        List<Address> addressList = detailsDao.queryBuilder()
                .where(ProductDao.Properties.MPatientId.eq(paietnId))

                .list();
        for (Product offer : offers) {
            temp.add(offer);
        }
        return offers;
    }



    public void createBasicProduct (Product patient){
        detailsDao.insert(patient);
    }

//    public void userBuysOffer (Offer patient){
//        detailsDao.insert(patient);
//    }

    public void update (Product patient){
        detailsDao.update(patient);
    }
    public void delete (Product patient){
        detailsDao.delete(patient);
    }
}
