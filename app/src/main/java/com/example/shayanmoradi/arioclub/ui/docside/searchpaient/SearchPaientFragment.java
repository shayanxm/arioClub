package com.example.shayanmoradi.arioclub.ui.docside.searchpaient;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.controller.authentication.Authentication;
import com.example.shayanmoradi.arioclub.database.OfferLab;
import com.example.shayanmoradi.arioclub.database.PatientLab;
import com.example.shayanmoradi.arioclub.model.offers.Offer;
import com.example.shayanmoradi.arioclub.model.users.Doctor;
import com.example.shayanmoradi.arioclub.model.users.Patient;
import com.example.shayanmoradi.arioclub.ui.docside.factor.CreateFactorActivity;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchPaientFragment extends Fragment {
    Patient currentPatient;
    @BindView(R.id.paient_name_et)
    EditText mPaietnNameEt;
    @BindView(R.id.paient_national_id_et)
    EditText mPaientNationalIdEt;
    @BindView(R.id.paietn_value_tv)
    TextView paientValueTv;
    @BindView(R.id.loged_in_name_tv)
    TextView loggedInNameTv;
    @BindView(R.id.loged_in_phone_tv)
    TextView loggedInNationalId;
    Doctor currentDoc;
    boolean paietnFound = false;

    public SearchPaientFragment() {
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
        View view = inflater.inflate(R.layout.fragment_search_paient, container, false);
        ButterKnife.bind(this, view);
        loggedInNameTv.setText(currentDoc.getMName());
        loggedInNationalId.setText(currentDoc.getMNationalCode() + "");

        return view;
    }

    @OnClick(R.id.search_paient_btn)
    void searchPaient() {
        // Toast.makeText(getContext(), "asdf", Toast.LENGTH_SHORT).show();
        String name = mPaietnNameEt.getText().toString();
        String nationalId = mPaientNationalIdEt.getText().toString();
        currentPatient = PatientLab.getInstance(getContext()).searchPaient(name, nationalId);
        if (currentPatient == null) {
            Toast.makeText(getContext(), "پیدا نشد", Toast.LENGTH_SHORT).show();
        } else {
            paietnFound = true;
            mPaietnNameEt.setText(currentPatient.getMName());
            mPaientNationalIdEt.setText(currentPatient.getMNationalCode());
            paientValueTv.setText(calcPaientValue() + "");
        }

    }

    @OnClick(R.id.paient_create_factor_btn)
    void onCreateFactor() {
        if (paietnFound) {
            Intent intent = new Intent(getContext(), CreateFactorActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(getContext(), "ابتدا بیماری جست و جو کنید", Toast.LENGTH_SHORT).show();
        }
    }

    private double calcPaientValue() {
        double totalyValue = 0;
        try {
            List<Offer> offers = OfferLab.getInstance(getContext()).getPaientBag(Authentication.getCurrentPAtient().getId());
            for (Offer offers1 : offers) {
                totalyValue += offers1.getMAmount();

            }
        } catch (Exception e) {
            Log.e("test", "list offer a bimar khaliye");
            return 0;

        }


        return totalyValue;
    }

    @OnClick(R.id.paient_create_factor_btn)
    void onFactorClick() {

    }
}
