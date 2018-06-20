package com.example.yangluo.applicationpass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),OtherActivity.class);
                MyApplication.getInstance().getData().put("Name","Yang");
                Log.d("MyApplication","inside MainActivity"+MyApplication.getInstance().getData().get("Name"));
                startActivity(intent);
            }
        });
    }
}
