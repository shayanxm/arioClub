package com.example.shayanmoradi.arioclub.ui.patientmainpage;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.database.OfferLab;
import com.example.shayanmoradi.arioclub.model.offers.Offer;
import com.example.shayanmoradi.arioclub.ui.Adapter.OfferAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientMainPageFragment extends Fragment implements OfferAdapter.OnUserAdapter{
OfferAdapter offerAdapter;
@BindView(R.id.offers_rv)RecyclerView offersRv;

    public PatientMainPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_patient_main_page, container, false);
        ButterKnife.bind(this,view);
        offersRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        offerAdapter = new OfferAdapter(this);

        offerAdapter.setItems(  OfferLab.getInstance(getContext()).getAllOffers());
        offersRv.setAdapter(offerAdapter);

        return view;
    }

    @Override
    public void onUserClicked(Offer user) {
        Toast.makeText(getContext(), user.getMName()+"", Toast.LENGTH_SHORT).show();

    }
}
