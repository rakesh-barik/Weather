package com.dumer.weather.data;

import android.os.Build;

import com.dumer.weather.BuildConfig;
import com.dumer.weather.data.local.DatabaseHelper;
import com.dumer.weather.data.local.PreferencesHelper;
import com.dumer.weather.data.model.WeatherResponse;
import com.dumer.weather.data.remote.IWeatherApiEndpoint;
import com.dumer.weather.data.remote.RestClientFactory;

import java.util.HashMap;

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
    final String FORECAST_BASE_URL =
            "http://api.openweathermap.org/data/2.5/forecast/daily?";
    final String QUERY_PARAM = "q";
    final String FORMAT_PARAM = "mode";
    final String UNITS_PARAM = "units";
    final String DAYS_PARAM = "cnt";
    final String APPID_PARAM = "APPID";
    String format = "json";
    String units = "metric";
    int numDays = 14;

    @Inject
    public DataManager(IWeatherApiEndpoint weatherApiEndpoint, DatabaseHelper databaseHelper, PreferencesHelper preferencesHelper) {
        this.weatherApiEndpoint = weatherApiEndpoint;
        this.databaseHelper = databaseHelper;
        this.preferencesHelper = preferencesHelper;
    }

    public Observable<WeatherResponse> getDailyWeather(){
        HashMap<String, String> queryMap = new HashMap<>();
        queryMap.put(QUERY_PARAM,"kolkata");
        queryMap.put(FORMAT_PARAM,format);
        queryMap.put(UNITS_PARAM,units);
        queryMap.put(DAYS_PARAM,Integer.toString(numDays));
        queryMap.put(APPID_PARAM,BuildConfig.OPEN_WEATHER_MAP_API_KEY);
            return weatherApiEndpoint.getDailyWeather(queryMap);
    }
}
