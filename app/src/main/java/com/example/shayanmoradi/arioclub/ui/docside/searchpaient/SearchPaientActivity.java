package com.example.shayanmoradi.arioclub.ui.docside.searchpaient;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.ui.SingleFragmentActivity;

import androidx.fragment.app.Fragment;

public class SearchPaientActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new SearchPaientFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_search_paient;
    }

    @Override
    public int getContinerResId() {
        return R.id.continer;
    }
}
