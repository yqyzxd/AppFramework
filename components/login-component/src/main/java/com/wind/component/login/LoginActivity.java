package com.wind.component.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wind.base.BaseApplication;
import com.wind.base.BaseInjectActivity;
import com.wind.base.di.HasComponent;
import com.wind.base.utils.Navigator;
@Route(path = "/login/activity")
public class LoginActivity extends BaseInjectActivity<LoginComponent> implements HasComponent<LoginComponent> {

    public static void start(Context context) {
        Navigator.navigate(context, LoginActivity.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);
        replaceFragment(new LoginFragment());
    }

    @Override
    protected void initializeInjector() {

        mComponent = DaggerLoginComponent.builder()
                .appComponent(BaseApplication.getInstance().getAppComponent())
                .build();
    }
}
