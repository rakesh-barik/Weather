package com.dumer.weather.ui.main;

import android.util.Log;

import com.dumer.weather.data.DataManager;
import com.dumer.weather.data.model.List;
import com.dumer.weather.data.model.WeatherResponse;
import com.dumer.weather.ui.base.Presenter;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rakesh.barik on 17-04-2016.
 */
public class MainPresenter implements Presenter<MainMvpView> {

    private final DataManager mDataManager;
    public Subscription mSubscription;
    MainMvpView mainMvpView;

    @Inject
    public MainPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        this.mainMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mainMvpView = null;
        if(mSubscription !=null)mSubscription.unsubscribe();
    }

    public void loadDailyWeather(){
        if(mSubscription !=null)mSubscription.unsubscribe();
        mSubscription = getDailyWeatherObservable().subscribe(new Subscriber<WeatherResponse>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("MainPresenter-","-dailyweather-",e);
            }

            @Override
            public void onNext(WeatherResponse weatherResponse) {
                if(weatherResponse != null){
                    presentRequiredInfoToView(weatherResponse);

                }
            }
        });
    }

    private void presentRequiredInfoToView(WeatherResponse weatherResponse) {
        mainMvpView.showWeather(weatherResponse);
    }


    private Observable<WeatherResponse> getDailyWeatherObservable(){
        return mDataManager.getDailyWeather()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
