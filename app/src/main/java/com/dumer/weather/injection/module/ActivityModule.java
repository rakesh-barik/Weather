package com.dumer.weather.injection.module;

import android.app.Activity;
import android.content.Context;

import com.dumer.weather.injection.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rakesh.barik on 29-03-2016.
 */
@Module
public class ActivityModule {
    Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    Activity provideActivity(){
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return mActivity;
    }
}
