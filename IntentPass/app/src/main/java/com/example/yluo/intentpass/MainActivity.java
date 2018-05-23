package com.example.yluo.intentpass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =  findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent();
                intent.setClass(getApplicationContext(),OtherActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("myname","yangluo");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
