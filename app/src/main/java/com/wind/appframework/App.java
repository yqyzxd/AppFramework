package com.wind.appframework;

import com.wind.base.BaseApplication;

public class App extends BaseApplication {

    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

    }


    public static App get() {
        return sInstance;
    }



}
