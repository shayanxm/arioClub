package com.example.shayanmoradi.arioclub.ui.Login;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.controller.authentication.Authentication;
import com.example.shayanmoradi.arioclub.database.DoctorLab;
import com.example.shayanmoradi.arioclub.database.PatientLab;
import com.example.shayanmoradi.arioclub.model.users.Doctor;
import com.example.shayanmoradi.arioclub.model.users.Patient;
import com.example.shayanmoradi.arioclub.ui.mainpage.MainPageActivity;
import com.example.shayanmoradi.arioclub.ui.patientmainpage.PatientMainPageActivity;
import com.example.shayanmoradi.arioclub.ui.signup.SignUpActivity;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.shayanmoradi.arioclub.ui.Login.LoginActivity.userTypeCode;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogInFragment extends Fragment {
    @BindView(R.id.phone_et)
    EditText phoneEt;
    @BindView(R.id.password_et)
    EditText passEt;
    int mUserTypeCode;

    public static LogInFragment newInstance(int userType) {

        Bundle args = new Bundle();
        args.putSerializable(userTypeCode, userType);

        LogInFragment fragment = new LogInFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public LogInFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserTypeCode = (Integer) getArguments().getSerializable(userTypeCode);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logoin, container, false);
        ButterKnife.bind(this, view);
        Toast.makeText(getActivity(), mUserTypeCode + "user type", Toast.LENGTH_SHORT).show();

        return view;
    }


    @OnClick(R.id.login_btn)
    void loginBtnCLick() {
        try {


            if (mUserTypeCode == 0) {


                Doctor doctor = DoctorLab.getInstance(getContext()).getDetail(passEt.getText().toString(), phoneEt.getText().toString());
                Authentication.DoclogInTor(doctor);
                Toast.makeText(getContext(), doctor.getMPhoneNumber() + "welcome", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),MainPageActivity.class);
                startActivity(intent);
            } else {
                Patient patient = PatientLab.getInstance(getContext()).getDetail(passEt.getText().toString(), phoneEt.getText().toString());
                Authentication.PatientlogInTor(patient);
                Toast.makeText(getContext(), patient.getMPhoneNumber() + "welcome", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),PatientMainPageActivity.class);
                startActivity(intent);
            }
        }catch (Exception e){
            Toast.makeText(getActivity(), "اطلاعات وارد شده نادرست است.", Toast.LENGTH_SHORT).show();
            Log.e("test","incorrect incoming values");
        }

    }

    @OnClick(R.id.go_to_sign_up_tv)
    void goToSignUp() {
        Intent intent = SignUpActivity.newIntent(getActivity(),mUserTypeCode);
        startActivity(intent);

    }
}
