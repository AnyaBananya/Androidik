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
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final boolean DEBUG = false;
    private Boolean isCheckPressure;
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (DEBUG) {
            String msg = "[" + TAG + "] onCreate()";
            Log.d(TAG, "onCreate()");
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }

        setContentView(R.layout.activity_main);
        TextView txtViewCity = (TextView) findViewById(R.id.text_city);

        Intent intent = getIntent();

        city = intent.hasExtra(Constants.EXTRA_CITY) ? intent.getStringExtra(Constants.EXTRA_CITY) : getResources().getString(R.string.city);
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
            String msg = "[" + TAG + "] onClick()";
            Log.d(TAG, msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
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
            String msg = "[" + TAG + "] onStart()";
            Log.d(TAG, msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DEBUG) {
            String msg = "[" + TAG + "] onResume()";
            Log.d(TAG, msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (DEBUG) {
            String msg = "[" + TAG + "] onPause()";
            Log.d(TAG, msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (DEBUG) {
            String msg = "[" + TAG + "] onStop()";
            Log.d(TAG, msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (DEBUG) {
            String msg = "[" + TAG + "] onRestart()";
            Log.d(TAG, msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (DEBUG) {
            String msg = "[" + TAG + "] onDestroy()";
            Log.d(TAG, msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (DEBUG) {
            String msg = "[" + TAG + "] onRestoreInsSt()";
            Log.d(TAG, msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (DEBUG) {
            String msg = "[" + TAG + "] onSaveInsSt()";
            Log.d(TAG, msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }
}