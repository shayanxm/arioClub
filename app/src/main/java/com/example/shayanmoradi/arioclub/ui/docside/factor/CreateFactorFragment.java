package com.example.shayanmoradi.arioclub.ui.docside.factor;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.controller.authentication.Authentication;
import com.example.shayanmoradi.arioclub.controller.other.StaticData;
import com.example.shayanmoradi.arioclub.database.ProductLab;
import com.example.shayanmoradi.arioclub.model.Product;
import com.example.shayanmoradi.arioclub.model.TempProduct;
import com.example.shayanmoradi.arioclub.model.offers.Offer;
import com.example.shayanmoradi.arioclub.model.users.Doctor;
import com.example.shayanmoradi.arioclub.ui.Adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateFactorFragment extends Fragment implements ProductAdapter.OnUserAdapter {
    @BindView(R.id.loged_in_name_tv)
    TextView loggedInNameTv;
    @BindView(R.id.loged_in_phone_tv)
    TextView loggedInNationalId;
    @BindView(R.id.product_code_et)
    TextView productCodeEt;
    @BindView(R.id.product_count_et)
    TextView productCountEt;
    @BindView(R.id.show_product_list_rv)
    RecyclerView showProductListRv;
    List<Product> inFactorProducts;
    ProductAdapter productAdapter;

    Doctor currentDoc;

    public CreateFactorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentDoc = Authentication.getCurrentDoc();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_factor, container, false);
        ButterKnife.bind(this, view);
        loggedInNameTv.setText(currentDoc.getMName());
        loggedInNationalId.setText(currentDoc.getMNationalCode() + "");
        showProductListRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        //   productAdapter = new ProductAdapter(this);
        updateUi();
        return view;
    }

    void updateUi() {
        productAdapter = new ProductAdapter(this);
        productAdapter.setItems(StaticData.getInstance(getContext()).getTempProducts());

        showProductListRv.setAdapter(productAdapter);
    }

    @Override
    public void onUserClicked(Offer user) {

    }

    @OnClick(R.id.add_product_btn)
    void onClick() {
        try {
            if (productCountEt == null || productCountEt.getText().toString().equals("")) {
                productCountEt.setText(1 + "");
            }
            Product currentProduct = ProductLab.getInstance().getDetail(productCodeEt.getText().toString());
            TempProduct tempProduct = new TempProduct(currentProduct, Integer.parseInt(productCountEt.getText().toString()));
            StaticData.getInstance(getContext()).addToList(tempProduct);

            updateUi();
        } catch (Exception e) {
            Log.e("test", "product ba in code ndrim");
            Toast.makeText(getContext(), "محصولی با این کد وجود ندارد", Toast.LENGTH_SHORT).show();
        }


    }

    @OnClick(R.id.finialize_factor_btn)
    void finilizeClicked() {
        Toast.makeText(getContext(), "فاکتور ثبت شد", Toast.LENGTH_SHORT).show();
        StaticData.getInstance(getContext()).setTempProducts(new ArrayList<>());
        updateUi();
    }
}
