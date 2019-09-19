package com.wind.component.login.debug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.wind.component.login.LoginActivity;
import com.wind.component.login.R;

public class RunAloneActivity extends FragmentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_run_alone);

        LoginActivity.start(this);
    }
}
