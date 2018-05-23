package com.example.yluo.screenrotation;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart");
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("MainActivity","onResume");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("MainActivity","onStop");
    }
    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d("MainActivity","onRestart");
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String orientation = Integer.toString(this.getResources().getConfiguration().orientation);
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            orientation = "ORIENATION_PORTRAIT";
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            orientation = "ORIENTATION_LANDSCAPE";
        }
        Log.d("MainActivity","onConfigurationChanged  ...  "+orientation);
    }
    /** by default, when keyboard hide or screen orientation changes, they current activity would stop -> destroy -> create new instance
    but by adding " android:configChanges="keyboardHidden|orientation", the activity would not be destroyed
    **/
}
