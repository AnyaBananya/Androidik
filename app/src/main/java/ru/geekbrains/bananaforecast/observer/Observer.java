package ru.geekbrains.bananaforecast.observer;

import ru.geekbrains.bananaforecast.parcel.CityParcel;

public interface Observer {
    void selectCity(CityParcel cityParcel);
}
