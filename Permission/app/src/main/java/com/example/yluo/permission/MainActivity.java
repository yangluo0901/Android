package com.example.yluo.permission;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button google;
    private Button yahoo;
    private Button baidu;
    private final static String TAG = "MainActivity";
    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        google =  findViewById(R.id.google);
        yahoo =  findViewById(R.id.yahoo);
        baidu =  findViewById(R.id.baidu);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"google is clikced");
                clickReact(v);

            }
        });
        yahoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"yahoo is clikced");
                clickReact(v);
            }
        });
        baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"baidu is clikced");
                clickReact(v);
            }
        });

    }
    public void clickReact(View v)
    {
        int id =  v.getId();
        Log.i(TAG,Integer.toString(id));
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        switch (id)
        {
            case R.id.google:

                intent.setData(Uri.parse("http://www.google.com"));
                Log.i(TAG,"inside google");
                break;
            case R.id.yahoo:

                intent.setData(Uri.parse("http://www.yahoo.com"));
                Log.i(TAG,"inside yahoo");
                break;
            case R.id.baidu:
                intent.setData(Uri.parse("http://www.baidu.com"));
                Log.i(TAG,"inside baidu");
                break;
        }
//        startActivity(intent);
    }
}
