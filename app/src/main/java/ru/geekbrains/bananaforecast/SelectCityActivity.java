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
    private static final String TAG = SelectCityActivity.class.getSimpleName();

    private String selectedCity;
    private Boolean isCheckPressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (DEBUG) {
            String msg = "[" + TAG + "] onCreate()";
            Log.d(TAG, msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
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
            String msg = "[" + TAG + "] onClick()";
            Log.d(TAG, msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
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