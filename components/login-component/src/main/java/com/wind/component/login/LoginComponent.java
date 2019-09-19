package com.wind.component.login;

import com.wind.base.di.AppComponent;
import com.wind.base.di.BaseMvpComponent;
import com.wind.base.di.annotation.ActivityScope;
import com.wind.component.login.presenter.LoginPresenter;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class,modules = {LoginModule.class})
public interface LoginComponent extends BaseMvpComponent<LoginView, LoginPresenter> /*DaggerCommponent*/{
    void inject(LoginFragment loginFragment);

}
