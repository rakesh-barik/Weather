package com.dumer.weather.data.remote;

import android.content.Context;

import com.dumer.weather.BuildConfig;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

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
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(logging);
        Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(IWeatherApiEndpoint.WEATHER_ENDPOINT)
                                        .client(okHttpClient)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                        .build();
        return retrofit.create(IWeatherApiEndpoint.class);
    }
}
