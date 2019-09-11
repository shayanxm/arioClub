package com.example.shayanmoradi.arioclub.ui.docside.factor;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.controller.authentication.Authentication;
import com.example.shayanmoradi.arioclub.model.users.Doctor;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateFactorFragment extends Fragment {
    @BindView(R.id.loged_in_name_tv)TextView loggedInNameTv;
    @BindView(R.id.loged_in_phone_tv)TextView loggedInNationalId;
    Doctor currentDoc;

    public CreateFactorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentDoc=Authentication.getCurrentDoc();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_create_factor, container, false);
        ButterKnife.bind(this,view);
        loggedInNameTv.setText(currentDoc.getMName());
        loggedInNationalId.setText(currentDoc.getMNationalCode()+"");

        return view;
    }

}
