package com.example.yluo.explicitintent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.button_1);
        two = findViewById(R.id.button_2);
        three = findViewById(R.id.button_3);
        Handler handler=  new Handler();
        one.setOnClickListener(handler);
        two.setOnClickListener(handler);
        three.setOnClickListener(handler);
    }
    public class Handler implements View.OnClickListener
    {
        @Override
        public void onClick(View v) { //  v : the view that was clicked
            switch (v.getId())
            {
                case  R.id.button_1 :
                    Intent intent01 = new Intent();
                    //setClass(Context context, Class class)
                    intent01.setClass(getApplicationContext(), Activity_01.class);
                    startActivity(intent01);
                case  R.id.button_2 :
                    Intent intent02 = new Intent();
                    //setClassName(Context context, String classname)
                    intent02.setClassName(getApplicationContext(), "com.example.yluo.explicitintent.Activity_01");
                    startActivity(intent02);
                case  R.id.button_3 :
                    Intent intent03 = new Intent();
                    //setClassName(String packagename, String classname)
                    intent03.setClassName("com.example.yluo.explicitintent", "com.example.yluo.explicitintent.Activity_01");
                    startActivity(intent03);
            }
        }
    }
}
