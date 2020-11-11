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
import androidx.appcompat.app.AppCompatActivity;

public class SelectCityActivity extends AppCompatActivity implements View.OnClickListener {
    private static final boolean DEBUG = false;
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

        setContentView(R.layout.activity_select_city);
        AutoCompleteTextView autoCompleteCities = findViewById(R.id.editTextCity);

        Intent intent = getIntent();
        selectedCity = intent.getStringExtra(Constants.EXTRA_CITY);
        autoCompleteCities.setText(selectedCity);

        autoCompleteCities.setAdapter(new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.cities)));
        autoCompleteCities.setOnItemClickListener((parent, view, position, rowId) -> selectedCity = (String) parent.getItemAtPosition(position));

        CheckBox checkBxPressure = findViewById(R.id.checkBoxPressure);
        isCheckPressure = intent.getBooleanExtra(Constants.EXTRA_PRESSURE, false);
        checkBxPressure.setChecked(isCheckPressure);
        checkBxPressure.setOnCheckedChangeListener((buttonView, isChecked) -> isCheckPressure = checkBxPressure.isChecked());

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
            intent.putExtra(Constants.EXTRA_CITY, selectedCity);
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