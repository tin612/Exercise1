package com.tin612.exercise1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignUpStep1Activity extends AppCompatActivity {
    Button nextBtn;
    EditText email;
    EditText fname;
    EditText lname;
    EditText pnum;
    RadioButton male;
    RadioButton fmale;
    void init() {
        nextBtn = (Button) findViewById(R.id.nextButton);
        email = (EditText) findViewById(R.id.emailEditText);
        pnum = (EditText) findViewById(R.id.p_numEditText);
        fname = (EditText) findViewById(R.id.fnameEditText);
        lname = (EditText) findViewById(R.id.lnameEditText);
        male = (RadioButton) findViewById(R.id.mRadio);
        fmale = (RadioButton) findViewById(R.id.fmRadio);

    }
    protected int checkEmptyEditText()
    {
        if(email.getText().toString().trim().equals("") || pnum.getText().toString().trim().equals("")
                || lname.getText().toString().trim().equals("") || fname.getText().toString().trim().equals("")
                || (!male.isChecked() && !fmale.isChecked() ) )
            return 1;
        else return 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step1);
        if( getIntent().getBooleanExtra("Exit", false)){
            finish();
            return; // add this to prevent from doing unnecessary stuffs
        }
        init();
        fname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (fname.getText().toString().trim().equals(""))
                        fname.setError("You must enter First Name");
                }
            }
        });
        lname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (lname.getText().toString().trim().equals(""))
                        lname.setError("You must enter Last Name");
                }
            }
        });
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                {
                    if(email.getText().toString().trim().equals(""))  email.setError("You must enter Email");
                    else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
                    {
                        email.setError("Email is invalid");
                    }
                }
            }
        });
        pnum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                   if (pnum.getText().toString().trim().equals(""))
                        pnum.setError("You must enter Phone number");
                }
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkEmptyEditText() == 0) {
                    Intent step2 = new Intent(SignUpStep1Activity.this, SignUpStep2Activity.class);
                    step2.putExtra(Constant.fname, fname.getText().toString());
                    step2.putExtra(Constant.lname, lname.getText().toString());
                    step2.putExtra(Constant.email,email.getText().toString());
                    step2.putExtra(Constant.pnum, pnum.getText().toString());

                    startActivity(step2);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
