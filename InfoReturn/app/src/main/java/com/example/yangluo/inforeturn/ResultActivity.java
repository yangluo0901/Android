package com.example.yangluo.inforeturn;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultactivity);
        textView = findViewById(R.id.textView);
        textView.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent num =  new Intent();
                num.putExtra("phonenumber",textView.getText().toString());

                num.putExtra("tag","The request code is 1");
                setResult(10,num); // set the result based on result code and then system triggers the onActivityResult() inside MainActivity.java
                finish();
            }
        });

    }
}
