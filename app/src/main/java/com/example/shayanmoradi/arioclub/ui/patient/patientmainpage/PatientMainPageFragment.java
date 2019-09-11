package com.example.shayanmoradi.arioclub.ui.patient.patientmainpage;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.controller.authentication.Authentication;
import com.example.shayanmoradi.arioclub.database.OfferLab;
import com.example.shayanmoradi.arioclub.model.offers.Offer;
import com.example.shayanmoradi.arioclub.model.users.Patient;
import com.example.shayanmoradi.arioclub.ui.Adapter.OfferAdapter;

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
public class PatientMainPageFragment extends Fragment implements OfferAdapter.OnUserAdapter {
    OfferAdapter offerAdapter;
    boolean bagToggle = true;
    Patient currentPatient;

    @BindView(R.id.offers_rv)
    RecyclerView offersRv;
    @BindView(R.id.loged_in_name_tv)TextView loggedInNameTv;
    @BindView(R.id.loged_in_phone_tv)TextView loggedInNationalIdTv;



    public PatientMainPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentPatient= Authentication.getCurrentPAtient();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_patient_main_page, container, false);
        ButterKnife.bind(this, view);
        loggedInNameTv.setText(currentPatient.getMName());
        loggedInNationalIdTv.setText(currentPatient.getMNationalCode()+"");

        offersRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        offerAdapter = new OfferAdapter(this);

        offerAdapter.setItems(OfferLab.getInstance(getContext()).getAllOffers());

        offersRv.setAdapter(offerAdapter);


        return view;
    }

    @Override
    public void onUserClicked(Offer user) {
        Toast.makeText(getContext(), user.getMName() + "", Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.show_bag_iv)
    void onBagClick() {
        if (bagToggle) {

            offerAdapter = new OfferAdapter(this);

            offerAdapter.setItems(OfferLab.getInstance(getContext()).getPaientBag(Authentication.getCurrentPAtient().getId()));

            offersRv.setAdapter(offerAdapter);
            Toast.makeText(getContext(), "سبد خرید", Toast.LENGTH_SHORT).show();
        } else {

            offerAdapter.setItems(OfferLab.getInstance(getContext()).getAllOffers());

            offersRv.setAdapter(offerAdapter);
            Toast.makeText(getContext(), "کلیه طرح ها", Toast.LENGTH_SHORT).show();

        }
        bagToggle=!bagToggle;
    }

}
