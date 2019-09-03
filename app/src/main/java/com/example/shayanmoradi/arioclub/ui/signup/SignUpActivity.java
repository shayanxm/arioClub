package com.example.shayanmoradi.arioclub.ui.signup;

import androidx.fragment.app.Fragment;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.ui.SingleFragmentActivity;

public class SignUpActivity extends SingleFragmentActivity {


    @Override
    public Fragment createFragment() {
        return new SignUpFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_sign_up;
    }

    @Override
    public int getContinerResId() {
        return R.id.fragment_continer;
    }
}
