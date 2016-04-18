package com.dumer.weather.ui.main;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dumer.weather.R;
import com.dumer.weather.data.DataManager;
import com.dumer.weather.data.model.WeatherResponse;
import com.dumer.weather.ui.base.BaseActivity;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends BaseActivity{


    @Inject
    DataManager dataManager;
    @Inject
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityComponent().inject(this);
        mainPresenter.loadDailyWeather();
    }
}
