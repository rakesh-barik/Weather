package com.dumer.weather.data.remote;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by rakesh.barik on 18-04-2016.
 */
public class RestClientFactory {

    @Inject
    public RestClientFactory() {
    }

    public static IWeatherApiEndpoint setUpRestClient(Context context){
        Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(IWeatherApiEndpoint.WEATHER_ENDPOINT)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                        .build();
        return retrofit.create(IWeatherApiEndpoint.class);
    }
}
