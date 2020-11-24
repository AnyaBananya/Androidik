package ru.geekbrains.bananaforecast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final boolean DEBUG = true;
    private City city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (DEBUG) {
            Log.d(TAG, "onCreate()");
        }

        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if (intent.hasExtra("parcel")) {
            city = (City) intent.getSerializableExtra("parcel");
        } else {
            city = new City(getResources().getStringArray(R.array.cities)[0], getResources().getStringArray(R.array.temperatures)[0],
                getResources().getStringArray(R.array.pressures)[0], getResources().getStringArray(R.array.windSpeeds)[0]);
        }

        TextView txtViewCity = (TextView) findViewById(R.id.text_city);
        txtViewCity.setText(city.getName());
        TextView txtViewTemperature = (TextView) findViewById(R.id.text_curr_temp);
        txtViewTemperature.setText(city.getTemperature());

        if (city.isNeedPressure()) {
            TextView txtViewLabelPressure = (TextView) findViewById(R.id.label_pressure);
            TextView txtViewPressure = (TextView) findViewById(R.id.text_pressure);
            txtViewPressure.setText(city.getPressure());
            txtViewLabelPressure.setVisibility(View.VISIBLE);
            txtViewPressure.setVisibility(View.VISIBLE);
        }

        Button btnSelectCity = (Button) findViewById(R.id.buttonSelectCity);
        btnSelectCity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (DEBUG) {
            Log.d(TAG, "onClick() " + city.getName());
        }

        if (v.getId() == R.id.buttonSelectCity) {
            Intent intent = new Intent(getApplicationContext(), SelectCityActivity.class);
            intent.putExtra(Constants.EXTRA_PARCEL, city);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (DEBUG) {
            Log.d(TAG, "onStart()");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DEBUG) {
            Log.d(TAG, "onResume()");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (DEBUG) {
            Log.d(TAG, "onPause()");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (DEBUG) {
            Log.d(TAG, "onStop()");
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (DEBUG) {
            Log.d(TAG, "onRestart()");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (DEBUG) {
            Log.d(TAG, "onDestroy()");
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (DEBUG) {
            Log.d(TAG, "onRestoreInsSt()");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable("CurrentCity", city);
        super.onSaveInstanceState(outState);
        if (DEBUG) {
            Log.d(TAG, "onSaveInsSt()");
        }
    }
}