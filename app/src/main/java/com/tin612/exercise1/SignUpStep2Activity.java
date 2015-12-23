package com.tin612.exercise1;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Process;

public class SignUpStep2Activity extends AppCompatActivity {
    Button doneBtn ;
    SeekBar seekBar;
    TextView salary;
    CheckBox check1;
    CheckBox check2;
    CheckBox check3;
    CheckBox check4;
    CheckBox check5;
    CheckBox check6;
    void init(){
        doneBtn = (Button)findViewById(R.id.doneButton);
        seekBar = (SeekBar)findViewById(R.id.salarySeekBar);
        salary = (TextView)findViewById(R.id.salaryTextView);
        check1 = (CheckBox)findViewById(R.id.checkbox1);
        check2 = (CheckBox)findViewById(R.id.checkbox2);
        check3 = (CheckBox)findViewById(R.id.checkbox3);
        check4 = (CheckBox)findViewById(R.id.checkbox4);
        check5 = (CheckBox)findViewById(R.id.checkbox5);
        check6 = (CheckBox)findViewById(R.id.checkbox6);
    }
    String firstname ;
     String lastname ;
    String email ;
    String pnum ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step2);
        init();
        Bundle bundle = getIntent().getExtras();
        firstname = bundle.getString(Constant.fname);
        lastname = bundle.getString(Constant.lname);
        email = bundle.getString(Constant.email);
        pnum = bundle.getString(Constant.pnum);
        Log.d("email" , email);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check1.isChecked() || check2.isChecked() || check3.isChecked() || check4.isChecked()
                        || check5.isChecked() || check6.isChecked()
                        ) {
//                    Intent intent = new Intent(SignUpStep2Activity.this, SignUpStep1Activity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    intent.putExtra("Exit", true);
//                    startActivity(intent);
//                    finish();
                    Intent step3 = new Intent(SignUpStep2Activity.this, SignUpStep3Activity.class);
                    step3.putExtra(Constant.fname, firstname);
                    step3.putExtra(Constant.lname, lastname);
                    step3.putExtra(Constant.email,email);
                    step3.putExtra(Constant.pnum, pnum);
                    step3.putExtra(Constant.sal, salary.getText().toString());
                    startActivity(step3);
                } else {
                    Toast.makeText(getApplicationContext(), "You must select one kind of sports", Toast.LENGTH_SHORT).show();
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = Math.round(progress/100)*100;
                seekBar.setProgress(progress);
                salary.setText("Your salary: " + progress + " dollars");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
    protected void onDestroy() {
        super.onDestroy();
    }
}
