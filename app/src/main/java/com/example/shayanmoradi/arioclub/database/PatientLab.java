package com.example.shayanmoradi.arioclub.database;

import android.content.Context;

import com.example.shayanmoradi.arioclub.model.users.Patient;
import com.example.shayanmoradi.arioclub.model.users.PatientDao;

import java.util.List;

public class PatientLab {
    public static PatientLab instance;
    private Context mContext;

    private DaoSession daoSession = App.getApp().getDaoSession();
    private PatientDao detailsDao = daoSession.getPatientDao();

    private PatientLab(Context context) {
        mContext = context.getApplicationContext();

    }

    public static PatientLab getInstance(Context context) {
        if (instance == null)
            instance = new PatientLab(context);
        return instance;
    }

    public Patient getDetail(String nationalId, String password) {


        List<Patient> patients = detailsDao.queryBuilder()
                .where(PatientDao.Properties.MNationalCode.eq(nationalId))
                .where(PatientDao.Properties.Password.eq(password))
                .list();
        for (Patient patient : patients) {
            return patient;
        }
        return null;
    }

    public Patient searchPaient(String name, String nationalID) {

        if (name == null||name.equals("")) {
            List<Patient> patients = detailsDao.queryBuilder()
                    .where(PatientDao.Properties.MNationalCode.eq(nationalID))

                    .list();
            for (Patient patient : patients) {
                return patient;
            }
        } else if (nationalID == null||nationalID.equals("")) {
            List<Patient> patients = detailsDao.queryBuilder()
                    .where(PatientDao.Properties.MName.eq(name))

                    .list();
            for (Patient patient : patients) {
                return patient;
            }
        }
//else if

        List<Patient> patients = detailsDao.queryBuilder()
                .where(PatientDao.Properties.MName.eq(name))
                .where(PatientDao.Properties.MNationalCode.eq(nationalID))
                .list();
        for (Patient patient : patients) {
            return patient;
        }
        return null;
    }

    public void signDoctorUp(Patient patient) {
        detailsDao.insert(patient);
    }

    public void update(Patient patient) {
        detailsDao.update(patient);
    }

    public void delete(Patient patient) {
        detailsDao.delete(patient);
    }
}
