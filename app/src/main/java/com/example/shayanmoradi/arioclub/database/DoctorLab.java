package com.example.shayanmoradi.arioclub.database;

import android.content.Context;

import com.example.shayanmoradi.arioclub.model.users.Doctor;
import com.example.shayanmoradi.arioclub.model.users.DoctorDao;

import java.util.List;

public class DoctorLab {
    public static DoctorLab instance;
    private Context mContext;

    private DaoSession daoSession = App.getApp().getDaoSession();
    private DoctorDao detailsDao = daoSession.getDoctorDao();

    private DoctorLab(Context context) {
        mContext = context.getApplicationContext();

    }

    public static DoctorLab getInstance(Context context) {
        if (instance == null)
            instance = new DoctorLab(context);
        return instance;
    }

    public Doctor getDetail(String nationalId, String password) {



        List<Doctor> doctorList = detailsDao.queryBuilder()
                .where(DoctorDao.Properties.MNationalCode.eq(nationalId))
           .where(DoctorDao.Properties.Password.eq(password))
                .list();
        for (Doctor doctors : doctorList) {
            return doctors;
        }
        return null;
    }

        public void signDoctorUp (Doctor doctor){
            detailsDao.insert(doctor);
        }

        public void update (Doctor doctor){
            detailsDao.update(doctor);
        }
        public void delete (Doctor doctor){
            detailsDao.delete(doctor);
        }
    }

