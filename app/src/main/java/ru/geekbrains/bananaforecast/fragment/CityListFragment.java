package ru.geekbrains.bananaforecast.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.geekbrains.bananaforecast.R;
import ru.geekbrains.bananaforecast.activity.MainActivity;
import ru.geekbrains.bananaforecast.observer.Publisher;
import ru.geekbrains.bananaforecast.observer.PublisherGetter;
import ru.geekbrains.bananaforecast.parcel.CityParcel;

public class CityListFragment extends Fragment {
    public static final String PARCEL = "parcel";
    CityParcel cityParcel;
    private boolean isExistCityInfo;
    private Publisher publisher;
    private static final boolean DEBUG = true;

    public CityListFragment() {
    }

    public static CityListFragment create(CityParcel city) {
        if (DEBUG) {
            Log.d(CityListFragment.class.getSimpleName(), "create");
        }
        CityListFragment fragment = new CityListFragment();
        Bundle args = new Bundle();
        args.putSerializable(PARCEL, city);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(CityListFragment.class.getSimpleName(), "onCreate");
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(CityListFragment.class.getSimpleName(), "onCreateView");
        }
        return inflater.inflate(R.layout.fragment_city_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(CityListFragment.class.getSimpleName(), "onViewCreated");
        }
        super.onViewCreated(view, savedInstanceState);
        initList(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(CityListFragment.class.getSimpleName(), "onActivityCreated");
        }
        super.onActivityCreated(savedInstanceState);
        isExistCityInfo = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (savedInstanceState != null) {
            cityParcel = (CityParcel) savedInstanceState.getSerializable("CurrentCity");
        } else {
            cityParcel = new CityParcel(getResources().getStringArray(R.array.cities)[0]);
        }

        if (isExistCityInfo) {
            showCityInfo(cityParcel);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable("CurrentCity", cityParcel);
        super.onSaveInstanceState(outState);
    }

    private void initList(View view, Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(CityListFragment.class.getSimpleName(), "initList");
        }
        LinearLayout linearLayout = (LinearLayout) view;
        String[] cities = getResources().getStringArray(R.array.cities);

        for (String city : cities) {
            TextView textView = new TextView(getContext(),null, 0, R.style.HeaderText);
            textView.setText(city);
            linearLayout.addView(textView);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setBackgroundColor(Color.YELLOW);
                    cityParcel = new CityParcel(city);
                    if (DEBUG) {
                        Log.d(CityListFragment.class.getSimpleName(), cityParcel.getCityName());
                    }
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                        showCityInfo(cityParcel);
                        publisher.notify(cityParcel);
                    }else{
                        Intent intent = new Intent(getContext(), MainActivity.class);
                        intent.putExtra(PARCEL, cityParcel);
                        startActivity(intent);
                    }

                }
            });
        }
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        publisher = ((PublisherGetter) context).getPublisher();
//    }

    private void showCityInfo(CityParcel cityParcel) {
        if (isExistCityInfo) {
            CityInfoFragment cityInfoFragment = (CityInfoFragment) getFragmentManager().findFragmentById(R.id.cityInfo);
            if (cityInfoFragment == null) {
                cityInfoFragment = CityInfoFragment.create(cityParcel);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.cityInfo, cityInfoFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        } else {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.putExtra(PARCEL, cityParcel);
            startActivity(intent);
        }
    }

}
