package ru.geekbrains.bananaforecast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnGoToCityList;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String msg = "[" + TAG + "] onCreate()";
        Log.d(TAG, msg);
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

        setContentView(R.layout.activity_main);

        btnGoToCityList = (Button) findViewById(R.id.buttonSelectCity);
        btnGoToCityList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String msg = "[" + TAG + "] onClick()";
        Log.d(TAG, msg);
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

        switch (v.getId()) {
            case R.id.buttonSelectCity:
                Intent intent = new Intent(this, SelectCityActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        String msg ="[" + TAG + "] onStart()";
        Log.d(TAG, msg);
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String msg = "[" + TAG + "] onResume()";
        Log.d(TAG, msg);
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        String msg = "[" + TAG + "] onPause()";
        Log.d(TAG, msg);
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        String msg = "[" + TAG + "] onStop()";
        Log.d(TAG, msg);
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        String msg = "[" + TAG + "] onRestart()";
        Log.d(TAG, msg);
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String msg = "[" + TAG + "] onDestroy()";
        Log.d(TAG, msg);
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String msg = "[" + TAG + "] onRestoreInsSt()";
        Log.d(TAG, msg);
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String msg = "[" + TAG + "] onSaveInsSt()";
        Log.d(TAG, msg);
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}