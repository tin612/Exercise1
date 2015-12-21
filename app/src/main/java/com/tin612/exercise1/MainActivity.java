package com.tin612.exercise1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button nextBtn;
    EditText email;
    void init(){
        nextBtn = (Button)findViewById(R.id.nextButton);
        email = (EditText)findViewById(R.id.emailEditText);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent step2 = new Intent(MainActivity.this, Step2.class);
                startActivity(step2);
            }
        });
    }
}
