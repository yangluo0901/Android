package com.example.yangluo.applicationpass;

import android.app.Application;
import android.util.Log;

import java.util.HashMap;

public class MyApplication extends Application {
    private HashMap<String,String> data = new HashMap<>();
    private static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        data.put("gender","male");
        Log.d("MyApplication","i am inside oncreate()"+data.get("gender"));
    }

    public static MyApplication getInstance() {
        Log.d("MyApplication"," i am inside getInstance()");
        return instance;
    }

    public HashMap<String, String> getData() {
        Log.d("MyApplication"," i am inside getData()");
        return data;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }


}
