package com.example.shayanmoradi.arioclub.ui.welcome;

import android.content.Intent;
import android.os.Bundle;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.ui.Login.LoginActivity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.login_as_doc_btn)void loginAsDocClicked(){
      Intent intent= LoginActivity.newIntent(this,0);
      startActivity(intent);


    }
    @OnClick(R.id.login_as_paient_btn)void loginAsPaientClicked(){
        Intent intent= LoginActivity.newIntent(this,1);
        startActivity(intent);

    }

}
