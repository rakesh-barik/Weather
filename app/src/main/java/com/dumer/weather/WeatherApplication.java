package com.dumer.weather;

import android.app.Application;
import android.content.Context;

import com.dumer.weather.data.DataManager;
import com.dumer.weather.injection.component.ApplicationComponent;
import com.dumer.weather.injection.component.DaggerApplicationComponent;
import com.dumer.weather.injection.module.ApplicationModule;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by rakesh.barik on 18-04-2016.
 */
public class WeatherApplication extends Application {

    @Inject
    Bus mEventBus;
    @Inject
    DataManager mDataManager;
    ApplicationComponent mApplicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
        mEventBus.register(this);
    }

    public static WeatherApplication get(Context context) {
        return (WeatherApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    public ApplicationComponent getmApplicationComponent() {
        return mApplicationComponent;
    }
}
