package com.tin612.exercise1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Step2 extends AppCompatActivity {
    Button doneBtn ;
    SeekBar seekBar;
    TextView salary;
    void init(){
        doneBtn = (Button)findViewById(R.id.doneButton);
        seekBar = (SeekBar)findViewById(R.id.salarySeekBar);
        salary = (TextView)findViewById(R.id.salaryTextView);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);
        init();
        seekBar.incrementProgressBy(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            Integer value = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                salary.setText("Your salary: "+value.toString() + " dollars");
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
