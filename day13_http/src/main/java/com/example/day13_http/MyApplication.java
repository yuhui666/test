package com.example.day13_http;

import android.app.Application;
import org.xutils.x;

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
