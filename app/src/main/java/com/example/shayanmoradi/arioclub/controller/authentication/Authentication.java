package com.example.shayanmoradi.arioclub.controller.authentication;

import android.content.Context;

import com.example.shayanmoradi.arioclub.model.users.Doctor;
import com.example.shayanmoradi.arioclub.model.users.Patient;

public class Authentication {
    private static Authentication instance;

    private Context mContext;
    static Doctor currentDoc;
   static Patient currentPAtient;


    private Authentication(Context context) {
        mContext = context.getApplicationContext();
    }

    public static Authentication getInstance(Context context) {
        if (instance == null)
            instance = new Authentication(context);

        return instance;
    }
    public static void authenticator(){
        if (currentDoc!=null){
            //loged in as doc

        }
        if (currentPAtient!=null){
            //loged in as patient
        }

    }
    public static void DoclogInTor(Doctor doctor){
        currentDoc=doctor;

    }
    public static void PatientlogInTor(Patient patient){
        currentPAtient=patient;

    }

    public static Doctor getCurrentDoc() {
        return currentDoc;
    }

    public static Patient getCurrentPAtient() {
        return currentPAtient;
    }
}
