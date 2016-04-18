package com.dumer.weather.injection.component;

import android.app.Application;
import android.content.Context;

import com.dumer.weather.WeatherApplication;
import com.dumer.weather.data.DataManager;
import com.dumer.weather.data.local.DatabaseHelper;
import com.dumer.weather.data.local.PreferencesHelper;
import com.dumer.weather.data.remote.RestClientFactory;
import com.dumer.weather.injection.ApplicationContext;
import com.dumer.weather.injection.module.ApplicationModule;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rakesh.barik on 29-03-2016.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(WeatherApplication weatherApplication);

    @ApplicationContext
    Context context();
    Application application();
    DataManager dataManager();
    RestClientFactory restClient();
    PreferencesHelper preferencesHelper();
    DatabaseHelper databaseHelper();
    Bus eventBus();
}
