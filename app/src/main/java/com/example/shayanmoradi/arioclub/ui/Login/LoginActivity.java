package com.example.shayanmoradi.arioclub.ui.Login;

import androidx.fragment.app.Fragment;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.ui.SingleFragmentActivity;

public class LoginActivity extends SingleFragmentActivity {
    @Override
    public int getContinerResId() {
        return R.id.login_continer;
    }

    @Override
    public Fragment createFragment() {
        return new LogInFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_login;
    }
}
