package com.example.tableorder.Enum;

import android.widget.EditText;

import com.example.tableorder.R;

public enum eSignUp {
    email(R.id.SignUp_Email_EditText),
    password(R.id.SignUp_Password_EditText),
    receckPassword(R.id.SignUp_RecheckPassword_EditText),
    name(R.id.SignUp_Name_EditText);

    private int id;
    private EditText editText;

    eSignUp(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
    public void setEditText(EditText editText) {
        this.editText = editText;
    }
    public EditText getEditText() {return this.editText;}
}
