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
    @BindView(R.id.national_code_et)EditText nationalCodeEt;
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

        //chech empty value

//        if (checkEmptyValue()){
//            Toast.makeText(getContext(), "فیلد ها را پر کنید", Toast.LENGTH_SHORT).show();
//            return;
//        }
        if (mUserTypeCode==0) {

            Doctor doc = new Doctor();

            doc.setMName(phoneNumbEt.getText().toString());

            doc.setMNationalCode(nationalCodeEt.getText().toString());
            doc.setPassword(passEt.getText().toString());
            DoctorLab.getInstance(getActivity()).signDoctorUp(doc);
        }else {
            Patient patient = new Patient();
            patient.setMName(phoneNumbEt.getText().toString());
            patient.setMNationalCode(nationalCodeEt.getText().toString());
            patient.setPassword(passEt.getText().toString());
            PatientLab.getInstance(getActivity()).signDoctorUp(patient);
        }

        Toast.makeText(getContext(), "ثبت نام انجام شد", Toast.LENGTH_SHORT).show();
        getActivity().finish();


    }
    boolean checkEmptyValue(){
        boolean b1=!(phoneNumbEt.getText()==null);
        boolean b2=!(passEt.getText()==null);
        boolean b3=!(nationalCodeEt.getText()==null);

        return b1&b2&b3;
    }

}
