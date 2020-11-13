package ru.geekbrains.bananaforecast.parcel;

import java.io.Serializable;

public class CityParcel implements Serializable {
    private String cityName;

    public CityParcel(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
