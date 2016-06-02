package com.dumer.weather.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dumer.weather.R;
import com.dumer.weather.data.model.List;
import com.dumer.weather.data.model.WeatherResponse;
import com.dumer.weather.injection.ActivityContext;
import com.dumer.weather.ui.utility.Utility;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by rakesh.barik on 09-05-2016.
 */
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.WeatherItemViewHolder> {
    private static final int VIEW_TYPE_TODAY = 0;
    private static final int VIEW_TYPE_FUTURE_DAY = 1;

    // Flag to determine if we want to use a separate view for "today".
    private boolean mUseTodayLayout = true;

    private WeatherResponse weatherResponse;
    Context context;

    @Inject
    public ForecastAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    public void setWeatherResponse(WeatherResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
    }

    @Override
    public WeatherItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case VIEW_TYPE_TODAY:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_forecast_today,parent,false);
                break;
            case VIEW_TYPE_FUTURE_DAY:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_forecast,parent,false);
                break;
        }

        return new WeatherItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherItemViewHolder holder, int position) {
        if (weatherResponse != null) {
            List weatherList = weatherResponse.getList().get(position);
            int viewType = getItemViewType(position);
            switch (viewType){
                case VIEW_TYPE_TODAY:
                    holder.iconView.setImageResource(Utility.getArtResourceForWeatherCondition(weatherList.getWeather().get(0).getId()));
                    break;
                case VIEW_TYPE_FUTURE_DAY:
                    holder.iconView.setImageResource(Utility.getIconResourceForWeatherCondition(weatherList.getWeather().get(0).getId()));
                    break;
            }

            holder.dateView.setText(Utility.getFriendlyDayString(context, weatherList.getDt()));
            holder.descriptionView.setText(weatherList.getWeather().get(0).getMain());
            holder.highTempView.setText(Utility.formatTemperature(context, weatherList.getTemp().getMax()));
            holder.lowTempView.setText(Utility.formatTemperature(context, weatherList.getTemp().getMin()));
        }
    }


    @Override
    public int getItemCount() {

        return (weatherResponse == null) ? 0 : weatherResponse.getList().size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0 && mUseTodayLayout) ? VIEW_TYPE_TODAY : VIEW_TYPE_FUTURE_DAY;
    }



    public class WeatherItemViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.list_item_icon)
        ImageView iconView;
        @Bind(R.id.list_item_date_textview)
        TextView dateView;
        @Bind(R.id.list_item_forecast_textview)
        TextView descriptionView;
        @Bind(R.id.list_item_high_textview)
        TextView highTempView;
        @Bind(R.id.list_item_low_textview)
        TextView lowTempView;


        public WeatherItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
