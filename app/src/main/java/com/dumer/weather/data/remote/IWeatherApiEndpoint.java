package com.dumer.weather.data.remote;

import com.dumer.weather.data.model.WeatherResponse;

import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import rx.Observable;

/**
 * Created by rakesh.barik on 17-04-2016.
 */
public interface IWeatherApiEndpoint {

    String WEATHER_ENDPOINT = "http://api.openweathermap.org";
    /*String format = "json";
    String units = "metric";
    int numDays = 14;*/

    /*@GET("/weather")
    void getWeather(@Query("q") String cityName,
                    Callback<WeatherResponse> callback);*/

    @GET("/data/2.5/forecast/daily?")
    Call<WeatherResponse> getWeather(@Query("q") String cityName);

    /*@GET("/data/2.5/forecast/daily?")
    Call<WeatherResponse> getDailyWeather(@QueryMap() Map<String,String> params);*/

    @GET("/data/2.5/forecast/daily?")
    Observable<WeatherResponse> getDailyWeather(@Query("q") String cityName);

}
