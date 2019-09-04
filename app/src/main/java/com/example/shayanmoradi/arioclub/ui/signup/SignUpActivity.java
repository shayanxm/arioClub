package com.example.shayanmoradi.arioclub.ui.signup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.ui.SingleFragmentActivity;

import androidx.fragment.app.Fragment;

public class SignUpActivity extends SingleFragmentActivity {

    int userTypeInt;
    public static final String userTypeCode="com.example.shayanmoradi.arioclub.ui.Login.usertype";
    public static Intent newIntent(Context context, int userType) {
        Intent intent = new Intent(context, SignUpActivity.class);
        intent.putExtra(userTypeCode,userType);

        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        userTypeInt = (Integer) getIntent().getSerializableExtra(userTypeCode);
        super.onCreate(savedInstanceState);

    }

    @Override
    public Fragment createFragment() {
        return SignUpFragment.newInstance(userTypeInt);
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
