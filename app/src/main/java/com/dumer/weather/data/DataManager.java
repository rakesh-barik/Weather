package com.dumer.weather.data;

import com.dumer.weather.data.local.DatabaseHelper;
import com.dumer.weather.data.local.PreferencesHelper;
import com.dumer.weather.data.model.WeatherResponse;
import com.dumer.weather.data.remote.IWeatherApiEndpoint;
import com.dumer.weather.data.remote.RestClientFactory;
import retrofit.Callback;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit.Call;
import rx.Observable;

/**
 * Created by rakesh.barik on 18-04-2016.
 */
@Singleton
public class DataManager {
    private IWeatherApiEndpoint weatherApiEndpoint;
    private final DatabaseHelper databaseHelper;
    private final PreferencesHelper preferencesHelper;

    @Inject
    public DataManager(IWeatherApiEndpoint weatherApiEndpoint, DatabaseHelper databaseHelper, PreferencesHelper preferencesHelper) {
        this.weatherApiEndpoint = weatherApiEndpoint;
        this.databaseHelper = databaseHelper;
        this.preferencesHelper = preferencesHelper;
    }

    public void fetchWeatherUpdate(Callback<WeatherResponse> responseCallback){
        Call<WeatherResponse> call =  weatherApiEndpoint.getWeather("bangalore");
        call.enqueue(responseCallback);
    }

    public Observable<WeatherResponse> getDailyWeather(){
            return weatherApiEndpoint.getDailyWeather("bangalore");
    }
}
