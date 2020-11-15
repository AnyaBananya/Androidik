package ru.geekbrains.bananaforecast;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.geekbrains.bananaforecast.observer.Publisher;
import ru.geekbrains.bananaforecast.observer.PublisherGetter;

public class CitiesFragment extends Fragment {
    private static final String TAG = CitiesFragment.class.getSimpleName();
    private static final boolean DEBUG = true;
    private Publisher publisher;
    private City currentCity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(TAG, "onCreate()");
        }
        super.onCreate(savedInstanceState);

        if(savedInstanceState!=null){
            currentCity = (City) savedInstanceState.getSerializable(Constants.EXTRA_PARCEL);
            if (DEBUG) {
                Log.d(TAG, currentCity.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(TAG, "onCreateView()");
        }

        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(TAG, "onViewCreated()");
        }
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(TAG, "onActivityCreated()");
        }
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            currentCity = (City) savedInstanceState.getSerializable(Constants.EXTRA_PARCEL);
        } else {
            currentCity = new City(getResources().getStringArray(R.array.cities)[0], getResources().getStringArray(R.array.temperatures)[0],
                getResources().getStringArray(R.array.pressures)[0], getResources().getStringArray(R.array.windSpeeds)[0]);
        }
        if (DEBUG) {
            Log.d(TAG, currentCity.getName());
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        if (DEBUG) {
            Log.d(TAG, "onSaveInstanceState()");
        }
        outState.putSerializable(Constants.EXTRA_PARCEL, currentCity);
        super.onSaveInstanceState(outState);
    }

    private void initList(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        String[] cities = getResources().getStringArray(R.array.cities);
        TextView[] textViews = new TextView[cities.length];

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i];
            TextView textView = new TextView(getContext(), null, 0, R.style.HeaderText);
            textViews[i] = textView;
            textView.setText(city);
            linearLayout.addView(textView);
            int finalI = i;

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (TextView tv : textViews) {
                        tv.setBackgroundColor(Color.WHITE);
                    }
                    textView.setBackgroundColor(Color.YELLOW);
                    currentCity =
                        new City(city, getResources().getStringArray(R.array.temperatures)[finalI], getResources().getStringArray(R.array.pressures)[finalI],
                            getResources().getStringArray(R.array.windSpeeds)[finalI]);
                    publisher.notify(currentCity);
                }
            });
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        if (DEBUG) {
            Log.d(TAG, "onAttach()");
        }
        super.onAttach(context);
        publisher = ((PublisherGetter) context).getPublisher();
    }
}