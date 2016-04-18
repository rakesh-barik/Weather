package com.dumer.weather.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dumer.weather.WeatherApplication;
import com.dumer.weather.injection.component.ActivityComponent;
import com.dumer.weather.injection.component.DaggerActivityComponent;
import com.dumer.weather.injection.module.ActivityModule;

public class BaseActivity extends AppCompatActivity {

    public ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent activityComponent(){
        if(mActivityComponent == null){
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(WeatherApplication.get(this).getmApplicationComponent())
                    .build();
        }
        return mActivityComponent;
    }
}
