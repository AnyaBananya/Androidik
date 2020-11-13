package ru.geekbrains.bananaforecast.fragment;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.geekbrains.bananaforecast.R;
import ru.geekbrains.bananaforecast.parcel.CityParcel;

public class CityInfoFragment extends Fragment {
    public static final String PARCEL = "parcel";

    private static final boolean DEBUG = true;

    public CityInfoFragment() {
    }

    public static CityInfoFragment create(CityParcel city) {
        if (DEBUG) {
            Log.d(CityInfoFragment.class.getSimpleName(), "create");
        }
        CityInfoFragment fragment = new CityInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(PARCEL, city);
        fragment.setArguments(args);
        return fragment;
    }

    public CityParcel getParcel() {
        return (CityParcel) getArguments().getSerializable(PARCEL);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(CityInfoFragment.class.getSimpleName(), "onCreate");
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(CityInfoFragment.class.getSimpleName(), "onCreateView");
        }
        View layout = inflater.inflate(R.layout.fragment_city_info, container, false);
        //TextView cityLabel = layout.findViewById(R.id.label_city);
        TextView city = layout.findViewById(R.id.text_city);

        CityParcel cityParcel;
        if (savedInstanceState != null) {
            cityParcel = getParcel();
        } else {
            cityParcel = new CityParcel(getResources().getStringArray(R.array.cities)[0]);
        }

        city.setText(cityParcel.getCityName());
        return layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(CityInfoFragment.class.getSimpleName(), "onViewCreated");
        }
        super.onViewCreated(view, savedInstanceState);
    }

}