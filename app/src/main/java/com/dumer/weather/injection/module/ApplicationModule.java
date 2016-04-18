package com.dumer.weather.injection.module;

/**
 * Created by rakesh.barik on 29-03-2016.
 */

import android.app.Application;
import android.content.Context;

import com.dumer.weather.data.remote.IWeatherApiEndpoint;
import com.dumer.weather.data.remote.RestClientFactory;
import com.dumer.weather.injection.ApplicationContext;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies. Mainly singleton object that can be injected from
 * anywhere in the app.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    IWeatherApiEndpoint provideWeatherApiEndpoint(){
        return RestClientFactory.setUpRestClient(mApplication);
    }

    @Provides
    @Singleton
    Bus provideEventBus() {
        return new Bus();
    }

}
