package com.example.shayanmoradi.arioclub.ui.docside.factor;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.ui.SingleFragmentActivity;

import androidx.fragment.app.Fragment;

public class CreateFactorActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new CreateFactorFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_create_factor;
    }

    @Override
    public int getContinerResId() {
        return R.id.factory_continer;
    }
}
