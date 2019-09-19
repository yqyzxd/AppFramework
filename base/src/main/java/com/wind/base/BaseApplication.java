package com.wind.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wind.base.di.AppComponent;
import com.wind.base.di.AppModule;
import com.wind.base.di.DaggerAppComponent;
import com.wind.base.di.ProviderModule;

public class BaseApplication extends Application {
    private static BaseApplication instance;
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
        instance = this;
        if (BuildConfig.DEBUG) {
            ARouter.openLog(); // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
        modulesApplicationInit();
    }

    public static BaseApplication getInstance(){
        return instance;
    }

    public static Context getContext() {
        return getInstance().getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    //初始化component
    private void initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .providerModule(new ProviderModule())
                .build();
    }

    private void modulesApplicationInit(){
       /* for (String moduleImpl : ModuleConfig.MODULESLIST){
            try {
                Class<?> clazz = Class.forName(moduleImpl);
                Object obj = clazz.newInstance();
                if (obj instanceof ApplicationImpl){
                    ((ApplicationImpl) obj).onCreate(this);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }*/
    }
}