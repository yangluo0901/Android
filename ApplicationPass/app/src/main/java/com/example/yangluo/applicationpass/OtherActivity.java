package com.example.yangluo.applicationpass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otheractivity);
        String text = MyApplication.getInstance().getData().get("Name");
        textView = findViewById(R.id.textView);
        Log.d("MyApplication",text+"");
        textView.setText(text);
    }
}
