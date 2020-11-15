package ru.geekbrains.bananaforecast;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import ru.geekbrains.bananaforecast.observer.Observer;
import ru.geekbrains.bananaforecast.observer.Publisher;
import ru.geekbrains.bananaforecast.observer.PublisherGetter;

public class SelectCityActivity extends AppCompatActivity implements View.OnClickListener, PublisherGetter, Observer {
    private static final boolean DEBUG = true;
    private final Publisher publisher = new Publisher();
    private static final String TAG = "[" + SelectCityActivity.class.getSimpleName()+ "]";

    private City city;
    private Boolean isCheckPressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (DEBUG) {
            Log.d(TAG, "onCreate()");
            Toast.makeText(getApplicationContext(), "onCreate()", Toast.LENGTH_SHORT).show();
        }

        publisher.subscribe(this);
        setContentView(R.layout.activity_select_city);

        Intent intent = getIntent();
        if (intent.hasExtra("parcel")) {
            city = (City) intent.getSerializableExtra("parcel");
        } else {
            city = new City(getResources().getStringArray(R.array.cities)[0], getResources().getStringArray(R.array.temperatures)[0],
                getResources().getStringArray(R.array.pressures)[0], getResources().getStringArray(R.array.windSpeeds)[0]);
        }

        CheckBox cbNeedPressure = (CheckBox) findViewById(R.id.checkBoxPressure);
        cbNeedPressure.setOnCheckedChangeListener((buttonView, isChecked) -> city.setNeedPressure( cbNeedPressure.isChecked()));
        Log.d(SelectCityActivity.class.getSimpleName(), String.valueOf(cbNeedPressure.isChecked()));

        Button selectCity = (Button) findViewById(R.id.buttonSelectCity);
        selectCity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (DEBUG) {
            Log.d(TAG, "onClick()");
            Toast.makeText(getApplicationContext(), "onClick()", Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == R.id.buttonSelectCity) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("parcel", city);
            startActivity(intent);
        }
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
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
    public void selectCity(City cityParcel) {
        if (DEBUG) {
            Log.d(TAG, "selectCity(" + cityParcel.getName() + ")");
            Toast.makeText(getApplicationContext(), "selectCity(" + cityParcel.getName() + ")", Toast.LENGTH_SHORT).show();
        }
        city = cityParcel;
    }
}