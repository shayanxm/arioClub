package com.example.shayanmoradi.arioclub.controller.other;

import android.content.Context;

import com.example.shayanmoradi.arioclub.model.TempProduct;

import java.util.ArrayList;
import java.util.List;

public class StaticData {
    private static StaticData instance;

    private Context mContext;
public static List<TempProduct>tempProducts= new ArrayList<>();


    private StaticData(Context context) {
        mContext = context.getApplicationContext();
    }

    public static StaticData getInstance(Context context) {
        if (instance == null)
            instance = new StaticData(context);

        return instance;
    }

    public static List<TempProduct> getTempProducts() {
        return tempProducts;
    }

    public static void setTempProducts(List<TempProduct> tempProducts) {
        StaticData.tempProducts = tempProducts;
    }
    public static void addToList(TempProduct tempProduct){
        tempProducts.add(tempProduct);
    }

}
