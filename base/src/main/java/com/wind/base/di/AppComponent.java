package com.wind.base.di;


import com.wind.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by wind on 16/5/18.
 */
@Singleton
@Component(modules = {AppModule.class, ProviderModule.class})
public interface AppComponent {
    Retrofit provideRetrofit();
    BaseApplication providesApplication();

}
