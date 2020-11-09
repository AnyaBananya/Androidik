package ru.geekbrains.bananaforecast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnGoToCityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoToCityList = (Button) findViewById(R.id.buttonSelectCity);
        btnGoToCityList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSelectCity:
                Intent intent = new Intent(this, SelectCityActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}