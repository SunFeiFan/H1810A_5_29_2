package com.example.dell.h1810a_5_29_2.myapp;

import android.app.Application;

public class MyApp extends Application {


    private static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }


    public static MyApp getMyApp() {
        return myApp;
    }

}
