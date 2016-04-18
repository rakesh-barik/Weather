
package com.dumer.weather.data.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Temp {

    private Float day;
    private Float min;
    private Float max;
    private Float night;
    private Float eve;
    private Float morn;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Temp() {
    }

    /**
     * 
     * @param min
     * @param eve
     * @param max
     * @param morn
     * @param night
     * @param day
     */
    public Temp(Float day, Float min, Float max, Float night, Float eve, Float morn) {
        this.day = day;
        this.min = min;
        this.max = max;
        this.night = night;
        this.eve = eve;
        this.morn = morn;
    }

    /**
     * 
     * @return
     *     The day
     */
    public Float getDay() {
        return day;
    }

    /**
     * 
     * @param day
     *     The day
     */
    public void setDay(Float day) {
        this.day = day;
    }

    /**
     * 
     * @return
     *     The min
     */
    public Float getMin() {
        return min;
    }

    /**
     * 
     * @param min
     *     The min
     */
    public void setMin(Float min) {
        this.min = min;
    }

    /**
     * 
     * @return
     *     The max
     */
    public Float getMax() {
        return max;
    }

    /**
     * 
     * @param max
     *     The max
     */
    public void setMax(Float max) {
        this.max = max;
    }

    /**
     * 
     * @return
     *     The night
     */
    public Float getNight() {
        return night;
    }

    /**
     * 
     * @param night
     *     The night
     */
    public void setNight(Float night) {
        this.night = night;
    }

    /**
     * 
     * @return
     *     The eve
     */
    public Float getEve() {
        return eve;
    }

    /**
     * 
     * @param eve
     *     The eve
     */
    public void setEve(Float eve) {
        this.eve = eve;
    }

    /**
     * 
     * @return
     *     The morn
     */
    public Float getMorn() {
        return morn;
    }

    /**
     * 
     * @param morn
     *     The morn
     */
    public void setMorn(Float morn) {
        this.morn = morn;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
