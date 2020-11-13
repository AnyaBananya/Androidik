package ru.geekbrains.bananaforecast.observer;

import java.util.ArrayList;
import java.util.List;

import ru.geekbrains.bananaforecast.parcel.CityParcel;

public class Publisher {
    private List<Observer> observers;

    public Publisher() {
        observers = new ArrayList<>();
    }

    public void subcribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubcribe(Observer observer) {
        observers.remove(observer);
    }

    public void notify(CityParcel cityParcel) {
        for (Observer observer : observers) {
            observer.selectCity(cityParcel);
        }
    }
}
