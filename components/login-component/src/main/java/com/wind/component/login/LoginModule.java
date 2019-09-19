package com.wind.component.login;

import com.wind.base.usecase.Usecase;
import com.wind.component.login.request.LoginRequest;
import com.wind.component.login.response.LoginResponse;
import com.wind.component.login.usecase.LoginUsecase;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public  class LoginModule {

    @Provides
    public Usecase<LoginRequest, LoginResponse> provideLoginUsecase(Retrofit retrofit) {
        return new LoginUsecase(retrofit);
    }




}
