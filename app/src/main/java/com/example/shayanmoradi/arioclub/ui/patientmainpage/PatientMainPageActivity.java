package com.example.shayanmoradi.arioclub.ui.patientmainpage;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.ui.SingleFragmentActivity;

import androidx.fragment.app.Fragment;

public class PatientMainPageActivity extends SingleFragmentActivity {


    @Override
    public Fragment createFragment() {
        return new PatientMainPageFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_patient_main_page;
    }

    @Override
    public int getContinerResId() {
        return R.id.patient_main_page;
    }
}
