package com.example.shayanmoradi.arioclub.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.database.OfferLab;
import com.example.shayanmoradi.arioclub.database.ProductLab;
import com.example.shayanmoradi.arioclub.model.Product;
import com.example.shayanmoradi.arioclub.model.offers.Offer;
import com.example.shayanmoradi.arioclub.ui.Login.LoginActivity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity {
    private Boolean firstTime = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);


        if (isFirstTime())
            generateSampleTempData();

    }


    @OnClick(R.id.login_as_doc_btn)void loginAsDocClicked(){
      Intent intent= LoginActivity.newIntent(this,0);
      startActivity(intent);


    }
    @OnClick(R.id.login_as_paient_btn)void loginAsPaientClicked(){
        Intent intent= LoginActivity.newIntent(this,1);
        startActivity(intent);

    }
    private boolean isFirstTime() {
        if (firstTime == null) {
            SharedPreferences mPreferences = this.getSharedPreferences("first_time", Context.MODE_PRIVATE);
            firstTime = mPreferences.getBoolean("firstTime", true);
            if (firstTime) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putBoolean("firstTime", false);
                editor.commit();
            }
        }
        return firstTime;
    }

    private void generateSampleTempData() {
        Offer offer= new Offer();
        offer.setMName("طرح طلایی");
        offer.setMDesc("دارای تخفیف ۵۰ درصدی");
        offer.setMPrice(440000+"");
        offer.setMAmount(440000);
        OfferLab.getInstance(this).createBasicOffer(offer);
        Offer offer2= new Offer();
        offer2.setMName("طرح نقره ایی");
        offer2.setMDesc("دارای تخفیف ۵۰ درصدی");
        offer2.setMPrice(290000+"");
        offer2.setMAmount(29000);
        OfferLab.getInstance(this).createBasicOffer(offer2);
        Offer offer3= new Offer();
        offer3.setMName("طرح برنزی");
        offer3.setMDesc("دارای تخفیف ۵۰ درصدی");
        offer3.setMPrice(180000+"");
        offer3.setMAmount(18000);
        OfferLab.getInstance(this).createBasicOffer(offer3);





        Product product= new Product();
        product.setMNAme("عصب کشی");
        product.setMPrice(200000.0);
        product.setMCode(1+"");
        ProductLab.getInstance().createBasicProduct(product);
        Product product1= new Product();
        product1.setMNAme("کشیدن دندان");
        product1.setMPrice(100000.0);
        product1.setMCode(2+"");
        ProductLab.getInstance().createBasicProduct(product1);
        Product product2= new Product();
        product2.setMNAme("ارتو دنسی");
        product2.setMPrice(500000.0);
        product2.setMCode(3+"");


        ProductLab.getInstance().createBasicProduct(product2);
    }
}
