package com.ilyasd.examples.viewpagerexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.ilyasd.examples.viewpagerexample.MainActivity.S_REQ_CODE;


public class PersonAdder extends AppCompatActivity {
    private EditText M_fn;
    private EditText M_ln;
    private EditText M_phone;
    private EditText M_age;
    private EditText M_idField;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_adder);
        M_fn = findViewById(R.id.fnInput);
        M_ln = findViewById(R.id.lnInput);
        M_phone = findViewById(R.id.phoneInput);
        M_age = findViewById(R.id.ageInput);
        M_idField = findViewById(R.id.idInput);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void addAction(View v) {
        if (M_fn.getText().toString().equals("")  || M_ln.getText().toString().equals("")  ||  M_age.getText().toString().equals("") || M_phone.getText().toString().equals("")  || M_idField.getText().toString().equals("") ) {
            Toast.makeText(this, "Please Enter Your Details", Toast.LENGTH_SHORT).show();
            return;
        }

        Bundle L_newOne = new Bundle();
        L_newOne.putString("FirstName", M_fn.getText().toString());
        L_newOne.putString("LastName", M_ln.getText().toString());
        L_newOne.putString("Age", M_age.getText().toString());
        L_newOne.putString("PhoneNumber", M_phone.getText().toString());
        L_newOne.putString("IDNum",M_idField.getText().toString());
        Log.i("L_newOne Check",L_newOne.getString("FirstName"));

        Intent L_intent = new Intent();
        L_intent.putExtras(L_newOne);
        setResult(S_REQ_CODE,L_intent);


            finish();

    }
}