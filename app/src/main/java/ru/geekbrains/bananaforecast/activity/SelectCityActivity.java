package ru.geekbrains.bananaforecast.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import ru.geekbrains.bananaforecast.fragment.CityListFragment;
import ru.geekbrains.bananaforecast.parcel.CityParcel;
import ru.geekbrains.bananaforecast.R;
import ru.geekbrains.bananaforecast.fragment.SelectCityButtonFragment;
import ru.geekbrains.bananaforecast.observer.Publisher;
import ru.geekbrains.bananaforecast.observer.PublisherGetter;

public class SelectCityActivity extends AppCompatActivity implements View.OnClickListener, PublisherGetter {
    private static final boolean DEBUG = true;
    private Publisher publisher = new Publisher();
    public static final String PARCEL = "parcel";
    private static final String TAG = "[" + SelectCityActivity.class.getSimpleName()+ "]";

    private String selectedCity;
    private Boolean isCheckPressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (DEBUG) {
            Log.d(TAG, "onCreate()");
            Toast.makeText(getApplicationContext(), "onCreate()", Toast.LENGTH_SHORT).show();
        }
        Intent intent = getIntent();
        CityParcel cityParcel = new CityParcel(getResources().getStringArray(R.array.cities)[0]);
        CityListFragment.create(cityParcel);
        SelectCityButtonFragment.create(cityParcel);

        SelectCityButtonFragment selectCityButtonFragment = new SelectCityButtonFragment();
        publisher.subcribe(selectCityButtonFragment);

        setContentView(R.layout.activity_select_city);
       // selectedCity = intent.getStringExtra(Constants.EXTRA_CITY);
/*        autoCompleteCities.setText(selectedCity);

        autoCompleteCities.setAdapter(new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.cities)));
        autoCompleteCities.setOnItemClickListener((parent, view, position, rowId) -> selectedCity = (String) parent.getItemAtPosition(position));*/

        //CheckBox checkBxPressure = findViewById(R.id.checkBoxPressure);
        //isCheckPressure = intent.getBooleanExtra(Constants.EXTRA_PRESSURE, false);
       // checkBxPressure.setChecked(isCheckPressure);
       // checkBxPressure.setOnCheckedChangeListener((buttonView, isChecked) -> isCheckPressure = checkBxPressure.isChecked());

       // Button selectCity = (Button) findViewById(R.id.buttonSelectCity);
       // selectCity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (DEBUG) {
            Log.d(TAG, "onClick()");
            Toast.makeText(getApplicationContext(), "onClick()", Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == R.id.buttonSelectCity) {

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
           // intent.putExtra(PARCEL, cityParcel);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (DEBUG) {
            Log.d(TAG, "onStart()");
            Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DEBUG) {
            Log.d(TAG, "onResume()");
            Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (DEBUG) {
            Log.d(TAG, "onPause()");
            Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (DEBUG) {
            Log.d(TAG, "onStop()");
            Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (DEBUG) {
            Log.d(TAG, "onRestart()");
            Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (DEBUG) {
            Log.d(TAG, "onDestroy()");
            Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (DEBUG) {
            Log.d(TAG, "onRestoreInsSt()");
            Toast.makeText(getApplicationContext(), "onRestoreInsSt()", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (DEBUG) {
            Log.d(TAG, "onSaveInsSt()");
            Toast.makeText(getApplicationContext(), "onSaveInsSt()", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }
}