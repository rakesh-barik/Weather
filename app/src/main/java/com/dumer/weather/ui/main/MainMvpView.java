package com.dumer.weather.ui.main;

import com.dumer.weather.data.model.List;
import com.dumer.weather.data.model.WeatherResponse;
import com.dumer.weather.ui.base.MvpView;

import java.util.ArrayList;

/**
 * Created by rakesh.barik on 17-04-2016.
 */
public interface MainMvpView extends MvpView {
    void showWeather(WeatherResponse weatherResponse);
}
