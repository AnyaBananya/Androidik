package ru.geekbrains.bananaforecast.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.geekbrains.bananaforecast.R;
import ru.geekbrains.bananaforecast.activity.MainActivity;
import ru.geekbrains.bananaforecast.observer.Observer;
import ru.geekbrains.bananaforecast.parcel.CityParcel;

public class SelectCityButtonFragment extends Fragment implements Observer, View.OnClickListener {
    private CityParcel cityParcel;
    public static final String PARCEL = "parcel";
    public static final boolean DEBUG = true;

    public SelectCityButtonFragment() {
    }

    public static SelectCityButtonFragment create(CityParcel cityParcel) {
        if (DEBUG) {
            Log.d(SelectCityButtonFragment.class.getSimpleName(), "create");
            Log.d("createSelectCityButton", cityParcel.getCityName());
        }
        SelectCityButtonFragment fragment = new SelectCityButtonFragment();
        Bundle args = new Bundle();
        args.putSerializable(PARCEL, cityParcel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public CityParcel getParcel() {
        return (CityParcel) getArguments().getSerializable(PARCEL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(SelectCityButtonFragment.class.getSimpleName(), "onCreateView");
        }
        //   cityParcel = getParcel();
        if (savedInstanceState != null) {
            cityParcel = getParcel();
        } else {
            cityParcel = new CityParcel(getResources().getStringArray(R.array.cities)[0]);
        }
        return inflater.inflate(R.layout.fragment_select_city_button, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(SelectCityButtonFragment.class.getSimpleName(), "onViewCreatedSelectCity");
            Log.d(SelectCityButtonFragment.class.getSimpleName(), cityParcel.getCityName());
        }
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.buttonSelectCity);

        //        button.setOnClickListener(view1 -> {
        //            if(DEBUG){
        //                Log.d("onClickButtonSelectCity", cityParcel.getCityName());
        //            }
        //            Intent intent = new Intent(getContext(), MainActivity.class);
        //            intent.putExtra(PARCEL, getCityParcel());
        //            startActivity(intent);
        //        });
        button.setOnClickListener(this);
    }

    private CityParcel getCityParcel() {
        if (DEBUG) {
            Log.d(SelectCityButtonFragment.class.getSimpleName(), "getCityParcel");
            //       Log.d(SelectCityButtonFragment.class.getSimpleName(), getCityParcel().getCityName());
        }
        return cityParcel;
    }

    @Override
    public void selectCity(CityParcel cityParcel) {
        if (DEBUG) {
            Log.d(SelectCityButtonFragment.class.getSimpleName(), "selectCity 1");
            Log.d(SelectCityButtonFragment.class.getSimpleName(), cityParcel.getCityName());
        }
        this.cityParcel = cityParcel;

        if (DEBUG) {
            Log.d(SelectCityButtonFragment.class.getSimpleName(), "selectCity 2");
      //      Log.d(SelectCityButtonFragment.class.getSimpleName(), getCityParcel().getCityName());
        }
    }

    @Override
    public void onClick(View view) {
        if (DEBUG) {
            Log.d(SelectCityButtonFragment.class.getSimpleName(), "onClick");
            Log.d(SelectCityButtonFragment.class.getSimpleName(), cityParcel.getCityName());
        }
        Intent intent = new Intent(getContext(), MainActivity.class);
        intent.putExtra(PARCEL, getCityParcel());
        startActivity(intent);
    }
}