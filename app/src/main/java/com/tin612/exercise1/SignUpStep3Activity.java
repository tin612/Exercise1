package com.tin612.exercise1;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class SignUpStep3Activity extends AppCompatActivity {

    Button restart;
    Button sendEmail;
    String firstname ;
    String lastname ;
    String email ;
    String pnum;
    String salary;
    void init()
    {
        sendEmail = (Button)findViewById(R.id.sendEmailBtn);
        restart = (Button) findViewById(R.id.restastBtn);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step3);
        init();
        Bundle bundle = getIntent().getExtras();
        firstname = bundle.getString(Constant.fname);
        lastname = bundle.getString(Constant.lname);
        email = bundle.getString(Constant.email);
        pnum = bundle.getString(Constant.pnum);
        salary = bundle.getString(Constant.sal);
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_SUBJECT, "User's registration info");
                i.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
                i.putExtra(Intent.EXTRA_TEXT, firstname + '_' + lastname + "\n" + pnum + "\n" + salary + "dollars");
                i.setType("message/rfc822");
                startActivity(Intent.createChooser(i, "Choose an Email client :"));
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent step1 = new Intent(SignUpStep3Activity.this, SignUpStep1Activity.class);
                startActivity(step1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false); // disable the button
            actionBar.setDisplayHomeAsUpEnabled(false); // remove the left caret
            actionBar.setDisplayShowHomeEnabled(false); // remove the icon
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
