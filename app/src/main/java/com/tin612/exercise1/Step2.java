package com.tin612.exercise1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Process;

public class Step2 extends AppCompatActivity {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);
        init();
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1.isChecked() || check2.isChecked() || check3.isChecked() || check4.isChecked()
                        || check5.isChecked() || check6.isChecked()
                        )
                {
                    Intent intent = new Intent(Step2.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Exit", true);
                    startActivity(intent);
                    finish();
                } else
                {
                    Toast.makeText(getApplicationContext(),"You must select one kind of sports",Toast.LENGTH_SHORT).show();
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            Integer value = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = ((int) Math.round(progress / 100)) * 100;
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
    protected void onDestroy() {
        Process.killProcess(android.os.Process.myPid());
        super.onDestroy();
        getParent().finish();
    }
}
