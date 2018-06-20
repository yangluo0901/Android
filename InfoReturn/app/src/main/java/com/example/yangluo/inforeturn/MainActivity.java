package com.example.yangluo.inforeturn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    private EditText number_call;
    private Button call ;
    private EditText number_call1;
    private Button call1 ;
    private final static int CALL_CODE = 0;
    private final static int CALL_CODE1 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number_call = findViewById(R.id.editText);
        call = findViewById(R.id.button);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), ResultActivity.class);
                startActivityForResult(intent,CALL_CODE);
            }
        });
        number_call1 = findViewById(R.id.editText1);
        call1 = findViewById(R.id.button1);
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), NewActivity.class);
                startActivityForResult(intent,CALL_CODE1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
            //request code is used to recognize the where the request are originated from
    {
        Bundle bundle = new Bundle();
        bundle = data.getExtras();
        String phone_number = bundle.getString("resultCode");
        String phone_number1 = bundle.getString("tag");
//        if (requestCode == CALL_CODE)// choose object based on requestCode
//        {
//            number_call.setText(phone_number);
//        }
//        else if(requestCode ==CALL_CODE1)
//        {
//            number_call1.setText(phone_number1);
//        }
        if(resultCode == 10)//choose object based on resultCode
        {
            number_call.setText(phone_number1);
        }
        else if(resultCode == 11)
        {
            number_call1.setText(phone_number);
        }

    }
}
/**
 * Comment:
 * The requestCode is used when different components have listeners that direct to same activity;
 * while the resultCode is used when direct to different activities
 */

