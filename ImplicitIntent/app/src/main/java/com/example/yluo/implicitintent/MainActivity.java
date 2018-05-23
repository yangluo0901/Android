package com.example.yluo.implicitintent;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_one = findViewById(R.id.btn_one);
        btn_one.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent =  new Intent();
                intent.setAction(Intent.ACTION_VIEW); // what you want to do
                intent.addCategory(Intent.CATEGORY_BROWSABLE);// what component you want to use to handle this intent(information)
                intent.setData(Uri.parse("http://www.google.com"));// in this case. if using browser to display, this line contains the data you are going to display
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(this.getClass().getName(),"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(this.getClass().getName(),"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(this.getClass().getName(),"onDestroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        String ori = "";
        super.onConfigurationChanged(newConfig);
        Log.d(this.getClass().getName(),"Configchanged");

        int orientation = getApplicationContext().getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            ori = "landscape";
        }
        else if(orientation ==  Configuration.ORIENTATION_PORTRAIT)
        {
            ori = "portrait";
        }
        Log.d(this.getClass().getName(),ori);
    }

    protected void onPause()
    {
        super.onPause();
        Log.d(this.getClass().getName(),"onPause");

    }
}
