package com.example.shayanmoradi.arioclub.ui;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    public abstract Fragment createFragment();

    @LayoutRes
    public abstract int getLayoutResId();
    public abstract int getContinerResId();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.findFragmentById(getContinerResId()) == null) {
            fragmentManager.beginTransaction()
                    .add(getContinerResId(), createFragment())
                    .commit();
        }
    }
}
