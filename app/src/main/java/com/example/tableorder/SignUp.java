package com.example.tableorder;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tableorder.Enum.eSignUp;
import com.example.tableorder.asset.AbstractFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AbstractFragment {

    private Button SignUp_SignUp_Button, SginUp_Back_Button;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected int getViewId() {
        return R.layout.fragment_sign_up;
    }

    @Override
    protected void associate(View view) {
        for(com.example.tableorder.Enum.eSignUp eSignUp : eSignUp.values()) {
            eSignUp.setEditText(view.findViewById(eSignUp.getId()));
        }
        this.SignUp_SignUp_Button = view.findViewById(R.id.SignUp_SignUp_Button);
        this.SginUp_Back_Button = view.findViewById(R.id.SginUp_Back_Button);

        this.mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    protected void initialize() {
        this.SignUp_SignUp_Button.setOnClickListener(v -> this.singUp());
        this.SginUp_Back_Button.setOnClickListener(v -> this.navigateTo(R.id.action_signUp_to_login));
    }

    private void singUp() {
        String email = eSignUp.email.getEditText().getText().toString();
        String password = eSignUp.password.getEditText().getText().toString();
        String recheckPassword = eSignUp.receckPassword.getEditText().getText().toString();
        String name = eSignUp.name.getEditText().getText().toString();

        User user = new User(email, password, name);

        mDatabase.push().setValue(user);


        if(email.isEmpty()) {
            Toast.makeText(this.getContext(), "이메일을 입력해 주세요", Toast.LENGTH_SHORT).show();
        } else {
            if (password.equals(recheckPassword)) {
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this.getActivity(), task -> {
                    if (task.isSuccessful()) {
                        this.navigateTo(R.id.action_signUp_to_login);
                        Toast.makeText(this.getContext(), email + ", " + password + "로 회원가입 완료! " + task.getResult().getUser().getUid(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this.getContext(), "회원가입 실패! " + task.getException(), Toast.LENGTH_SHORT).show();
                        Log.d("TEST123", task.getException() + "");
                    }
                });
            } else {
                Toast.makeText(this.getContext(), "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
            }
        }


    }
}