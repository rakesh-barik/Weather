package com.dumer.weather.ui.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.dumer.weather.R;
import com.dumer.weather.ui.base.BaseActivity;

public class MainActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }
}
