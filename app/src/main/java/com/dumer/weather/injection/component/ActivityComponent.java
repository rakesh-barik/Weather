package com.dumer.weather.injection.component;

import com.dumer.weather.injection.PerActivity;
import com.dumer.weather.injection.module.ActivityModule;
import com.dumer.weather.ui.main.ForecastFragment;
import com.dumer.weather.ui.main.MainActivity;

import dagger.Component;


/**
 * Created by rakesh.barik on 29-03-2016.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
    void inject(ForecastFragment homeFragment);

}
