package com.example.shayanmoradi.arioclub.ui.signup;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.database.DoctorLab;
import com.example.shayanmoradi.arioclub.database.PatientLab;
import com.example.shayanmoradi.arioclub.model.users.Doctor;
import com.example.shayanmoradi.arioclub.model.users.Patient;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.shayanmoradi.arioclub.ui.Login.LoginActivity.userTypeCode;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {
    int mUserTypeCode;


    @BindView(R.id.phone_et)
    EditText phoneNumbEt;
    @BindView(R.id.pass_et)
    EditText passEt;
    @BindView(R.id.confrim_sign_up_btn)
    Button signUpBtn;

    public static SignUpFragment newInstance(int userType) {

        Bundle args = new Bundle();
        args.putSerializable(userTypeCode, userType);

        SignUpFragment fragment = new SignUpFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserTypeCode = (Integer) getArguments().getInt(userTypeCode);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sgin_up, container, false);
        ButterKnife.bind(this, view);

        return view;

    }

    @OnClick(R.id.confrim_sign_up_btn)
    void onSignUpClick() {
        if (mUserTypeCode==0) {
            Doctor doc = new Doctor();
            doc.setPassword(passEt.getText().toString());
            doc.setMPhoneNumber(phoneNumbEt.getText().toString());
            DoctorLab.getInstance(getActivity()).signDoctorUp(doc);
        }else {
            Patient doc = new Patient();
            doc.setPassword(passEt.getText().toString());
            doc.setMPhoneNumber(phoneNumbEt.getText().toString());
            PatientLab.getInstance(getActivity()).signDoctorUp(doc);
        }

        Toast.makeText(getContext(), "ثبت نام انجام شد", Toast.LENGTH_SHORT).show();
        getActivity().finish();


    }

}
