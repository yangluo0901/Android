package com.example.yluo.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_linear;
    private Button btn_frame;
    private Button btn_table;
    private Button btn_relative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_linear =  findViewById(R.id.btn_linear);
        btn_frame = findViewById(R.id.btn_frame);
        btn_table = findViewById(R.id.btn_table);
        btn_relative = findViewById(R.id.btn_relative);
        btn_relative.setOnClickListener(this);
        btn_frame.setOnClickListener(this);
        btn_table.setOnClickListener(this);
        btn_linear.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        Intent intent =  new Intent();
        switch(v.getId())
        {
            case R.id.btn_linear:
                intent.setClass(getApplicationContext(),Layout_linear.class);
                break;
            case R.id.btn_frame:
                intent.setClass(getApplicationContext(),Layout_frame.class);
                break;
            case R.id.btn_table:
                intent.setClass(getApplicationContext(),Layout_table.class);
                break;
            case R.id.btn_relative:
                intent.setClass(getApplicationContext(),Layout_relative.class);
                break;
        }
        startActivity(intent);
    }
}
