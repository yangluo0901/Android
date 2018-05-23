package com.example.yluo.intentpass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OtherActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activity);
        Intent intent_other = getIntent();
        Bundle bundle_other = intent_other.getExtras();
        String text = bundle_other.getString("myname");
        textView =  findViewById(R.id.textView);
        textView.setText(text);
    }
}
