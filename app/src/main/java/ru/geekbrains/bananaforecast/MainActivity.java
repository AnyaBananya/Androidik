package ru.geekbrains.bananaforecast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "[" + MainActivity.class.getSimpleName() + "]";
    private static final boolean DEBUG = true;
    private Boolean isCheckPressure;
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (DEBUG) {
            Log.d(TAG, "onCreate()");
            Toast.makeText(getApplicationContext(), "onCreate()", Toast.LENGTH_SHORT).show();
        }

        setContentView(R.layout.activity_main);
        TextView txtViewCity = (TextView) findViewById(R.id.text_city);

        Intent intent = getIntent();

        city = intent.hasExtra(Constants.EXTRA_CITY) ? intent.getStringExtra(Constants.EXTRA_CITY) :
            new City(getResources().getStringArray(R.array.cities)[0], getResources().getStringArray(R.array.temperatures)[0]).getName();
        isCheckPressure = intent.getBooleanExtra(Constants.EXTRA_PRESSURE, false);

        txtViewCity.setText(city);

        if (isCheckPressure) {
            TextView txtViewLabelPressure = (TextView) findViewById(R.id.label_pressure);
            TextView txtViewPressure = (TextView) findViewById(R.id.text_pressure);
            txtViewLabelPressure.setVisibility(View.VISIBLE);
            txtViewPressure.setVisibility(View.VISIBLE);
        }

        Button btnSelectCity = (Button) findViewById(R.id.buttonSelectCity);
        btnSelectCity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (DEBUG) {
            Log.d(TAG, "onClick()");
            Toast.makeText(getApplicationContext(), "onClick()", Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == R.id.buttonSelectCity) {
            Intent intent = new Intent(getApplicationContext(), SelectCityActivity.class);
            intent.putExtra(Constants.EXTRA_CITY, city);
            intent.putExtra(Constants.EXTRA_PRESSURE, isCheckPressure);
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
}