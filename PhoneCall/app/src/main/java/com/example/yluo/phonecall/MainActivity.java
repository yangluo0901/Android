package com.example.yluo.phonecall;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback  {
    private EditText phonenumber;
    private Button dial;
    private static final int CALL_PHONE = 1;
    private Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phonenumber = findViewById(R.id.phonenumber);
        dial =  findViewById(R.id.call);

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = phonenumber.getText().toString();
                intent = new Intent();
                intent.setAction("android.intent.action.CALL");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse("tel:" + number));
                // if the permission is denied:
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //check if the permission is denied, if it is denied, it would return true which means should show rationale
                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CALL_PHONE)) {
                        Log.i("MainActivity", "the rationale is showing ...");
                    } else {
                        Log.i("MainActivity","I am requesting the permission");
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, CALL_PHONE);
                    }
                } else // IF  permission is granted
                {
                    Log.i("MainActivity","start activity ...");
                    startActivity(intent);
                }
            }

        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                          String[] permissions,
                                          int[] grantResults)
    {
        if (requestCode == CALL_PHONE)
        {
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Log.i("MainActivity","the call phone perssiom has been approved ! and start activity ...");

                startActivity(intent);
            }
            else
            {
                Log.i("MainActivity","the call phone permission is denied 1");
            }
        }else
        {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}
