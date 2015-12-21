package com.tin612.exercise1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button nextBtn;
    EditText email;
    EditText fname;
    EditText lname;
    EditText pnum;
    void init() {
        nextBtn = (Button) findViewById(R.id.nextButton);
        email = (EditText) findViewById(R.id.emailEditText);
        pnum = (EditText) findViewById(R.id.p_numEditText);
        fname = (EditText) findViewById(R.id.fnameEditText);
        lname = (EditText) findViewById(R.id.lnameEditText);
    }
    public final static boolean isValidEmail(CharSequence target) {
            return Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    public final static boolean isValidPhone(CharSequence target) {
        return Patterns.PHONE.matcher(target).matches();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if( getIntent().getBooleanExtra("Exit", false)){
            finish();
            return; // add this to prevent from doing unnecessary stuffs
        }
        init();
//        if(fname.getText().toString().length() == 0) fname.setError("You must enter First Name");
//        if(lname.getText().toString().length()==0) lname.setError("You must enter Last Name");
//        if(pnum.getText().toString().length()==0) pnum.setError("You must enter Last Name");
//        if(email.getText().toString().length()==0) email.setError("You must enter Last Name");
//        if(!isValidEmail(email.getText().toString())) email.setError("Email is invalid");
        fname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    //if(fname.getText().toString().length() == 0) fname.setError("You must enter First Name");
                }
                else
                {
                    if(fname.getText().toString().length() == 0) fname.setError("You must enter First Name");
                }
            }
        });
        lname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    //if(lname.getText().toString().length() == 0) fname.setError("You must enter First Name");
                }
                else
                {
                    if(lname.getText().toString().length() == 0) lname.setError("You must enter Last Name");
                }
            }
        });
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    if(!isValidEmail(email.getText().toString())) email.setError("Email is invalid");
                }
                else
                {
                    if(email.getText().toString().length() == 0)
                        email.setError("You must enter Last Name");
                    if(!isValidEmail(email.getText().toString())) email.setError("Email is invalid");
                }
            }
        });
        pnum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    if(!isValidPhone(email.getText().toString())) pnum.setError("Email is invalid");
                }
                else
                {
                    if(pnum.getText().toString().length() == 0)
                        pnum.setError("You must enter Last Name");
                    if(!isValidEmail(email.getText().toString())) pnum.setError("Email is invalid");
                }
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent step2 = new Intent(MainActivity.this, Step2.class);

                startActivity(step2);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
