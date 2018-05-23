package com.example.yluo.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class C3 extends Activity implements View.OnClickListener {
    private Button button_c1;
    private Button button_c2;
    private Button button_c3;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c3);
        button_c1 = findViewById(R.id.button_c1);
        button_c2 = findViewById(R.id.button_c2);
        button_c3 = findViewById(R.id.button_c3);
        button_c1.setOnClickListener(this);
        button_c2.setOnClickListener(this);
        button_c3.setOnClickListener(this);
        Toast.makeText(this,"C3 onCreate",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v)
    {
        Intent intent =  new Intent();
        switch (v.getId())
        {
            case R.id.button_c1:
                intent.setClass(getApplicationContext(),C1.class);
                break;
            case R.id.button_c2:
                intent.setClass(getApplicationContext(),C2.class);
                break;
            case R.id.button_c3:
                intent.setClass(getApplicationContext(),C3.class);
                break;
        }
        startActivity(intent);
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this,"C3 onNewIntent",Toast.LENGTH_SHORT).show();
    }


}
