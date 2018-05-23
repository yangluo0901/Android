package com.example.yluo.appicationpass;

import android.app.Application;

import java.util.HashMap;

public class MyApplication extends Application {
    private HashMap<String,String> info = new HashMap<String, String >();
    public HashMap<String, String> getData()
    {
        return info;
    }
    public void setData()
    {

    }
}
