package com.smartdroidesign.stormy.weather;

import com.smartdroidesign.stormy.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Current {

    private String locationLabel;
    private String icon;
    private String summary;
    private String timezone;

    private long time;

    private double temperature;
    private double humidity;
    private double precipChance;

    // Used in MainActivity (getCurrentDetails())
    public Current() {
    }

    // Will be used when binding the data as it possesses all of the objects attributes
    public Current(String locationLabel, String icon, String summary, String timezone,
                   long time, double temperature, double humidity, double precipChance) {
        this.locationLabel = locationLabel;
        this.icon = icon;
        this.summary = summary;
        this.timezone = timezone;
        this.time = time;
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipChance = precipChance;
    }

    public String getLocationLabel() {
        return locationLabel;
    }

    public void setLocationLabel(String locationLabel) {
        this.locationLabel = locationLabel;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getIconId() {
        //clear-day, clear-night, rain, snow, sleet, wind, fog, cloudy, partly-cloudy-day, or partly-cloudy-night.
        // (Developers should ensure that a sensible default is defined, as additional values, such as hail, thunderstorm, or tornado
        int iconId = R.drawable.clear_day;

        switch (icon) {
            case "clear-day":
                iconId = R.drawable.clear_day;
                break;
            case "clear-night":
                iconId = R.drawable.clear_night;
                break;
            case "rain":
                iconId = R.drawable.rain;
                break;
            case "snow":
                iconId = R.drawable.snow;
                break;
            case "sleet":
                iconId = R.drawable.sleet;
                break;
            case "wind":
                iconId = R.drawable.wind;
                break;
            case "fog":
                iconId = R.drawable.fog;
                break;
            case "cloudy":
                iconId = R.drawable.cloudy;
                break;
            case "partly-cloudy-day":
                iconId = R.drawable.partly_cloudy;
                break;
            case "partly-cloudy-night":
                iconId = R.drawable.cloudy_night;
                break;


        }
        return iconId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public long getTime() {
        return time;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimeZone(String timezone) {
        this.timezone = timezone;
    }

    public String getFormattedTime (){
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");

        formatter.setTimeZone(TimeZone.getTimeZone(timezone));

        Date dateTime = new Date(time * 1000);
        return formatter.format(dateTime);
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPrecipChance() {
        return precipChance;
    }

    public void setPrecipChance(double precipChance) {
        this.precipChance = precipChance;
    }

}


