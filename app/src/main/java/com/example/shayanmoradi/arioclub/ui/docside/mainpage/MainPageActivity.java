package com.example.shayanmoradi.arioclub.ui.docside.mainpage;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.ui.SingleFragmentActivity;

import androidx.fragment.app.Fragment;

public class MainPageActivity extends SingleFragmentActivity {


    @Override
    public Fragment createFragment() {
        return new MainPageFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main_page;
    }

    @Override
    public int getContinerResId() {
        return R.id.main_continer;
    }
}
