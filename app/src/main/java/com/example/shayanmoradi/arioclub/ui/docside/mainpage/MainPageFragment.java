package com.example.shayanmoradi.arioclub.ui.docside.mainpage;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.controller.authentication.Authentication;
import com.example.shayanmoradi.arioclub.database.OfferLab;
import com.example.shayanmoradi.arioclub.model.offers.Offer;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainPageFragment extends Fragment {
    String mName;
    String mPhoneNumb;


@BindView(R.id.offer_name_et)EditText mOfferNameEt;
@BindView(R.id.offer_off_et)EditText mOfferOffEt;
@BindView(R.id.loged_in_name_tv)TextView logedInNameTv;
    @BindView(R.id.loged_in_phone_tv)TextView logedInPhoneTv;

    public MainPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mName=Authentication.getCurrentDoc().getMName();
        mPhoneNumb=Authentication.getCurrentDoc().getMPhoneNumber();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);
        ButterKnife.bind(this,view);
        logedInNameTv.setText(mName);
        logedInPhoneTv.setText(mPhoneNumb);

        return view;
    }
    @OnClick(R.id.offer_submit_btn)void sumbitOffer(){
            Offer offer = new Offer();
            offer.setMName(mOfferNameEt.getText().toString());
            offer.setMAmount(Double.parseDouble( mOfferOffEt.getText().toString()));

            OfferLab.getInstance(getActivity()).createBasicOffer(offer);


    }

}
