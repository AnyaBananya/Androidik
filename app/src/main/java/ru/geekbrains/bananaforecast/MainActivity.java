package ru.geekbrains.bananaforecast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

import ru.geekbrains.bananaforecast.model.WeatherRequest;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final boolean DEBUG = false;
    private static final int DAY_COUNT = 5;
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s,RU&appid=%s";
    private City city;
    private static final int SETTING_CODE = 88;
    private TextView txtViewCity;
    private TextView txtViewTemperature;
    private TextView txtViewPressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (DEBUG) {
            Log.d(TAG, "onCreate()");
        }

        setContentView(R.layout.activity_main);

        txtViewCity = (TextView) findViewById(R.id.text_city);
        txtViewTemperature = (TextView) findViewById(R.id.text_curr_temp);
        txtViewPressure = (TextView) findViewById(R.id.text_pressure);

        Intent intent = getIntent();
        if (intent.hasExtra("parcel")) {
            city = (City) intent.getSerializableExtra("parcel");
        } else {
            city = new City(getResources().getStringArray(R.array.cities)[0]);
        }

        final URL uri;
        try {
            uri = new URL(String.format(WEATHER_URL, URLEncoder.encode(city.getName(), StandardCharsets.UTF_8.toString()), BuildConfig.WEATHER_API_KEY));

            final Handler handler = new Handler();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpsURLConnection urlConnection = null;
                    try {
                        urlConnection = (HttpsURLConnection) uri.openConnection();
                        urlConnection.setRequestMethod("GET");
                        urlConnection.setReadTimeout(10000);
                        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        String result = getLines(in);
                        Gson gson = new Gson();
                        final WeatherRequest weatherRequest = gson.fromJson(result, WeatherRequest.class);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                displayWeather(weatherRequest);
                            }
                        });
                    } catch (Exception e) {
                        Log.e(TAG, "Fail connection", e);
                        e.printStackTrace();
                    } finally {
                        if (null != urlConnection) {
                            urlConnection.disconnect();
                        }
                    }
                }
            }).start();
        } catch (MalformedURLException e) {
            Log.e(TAG, "Fail URI", e);
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Fail encode URL", e);
            e.printStackTrace();
        }

        txtViewCity.setText(city.getName());
        txtViewTemperature.setText(city.getTemperature());
        txtViewPressure.setText(city.getPressure());

        Button setting = findViewById(R.id.button3);
        setting.setOnClickListener(v -> {
            Intent intent1 = new Intent(MainActivity.this, SettingsActivity.class);
            startActivityForResult(intent1, SETTING_CODE);
        });

        initRecyclerView(generateDays(), generateTemperatures());

        Button btnSelectCity = (Button) findViewById(R.id.buttonSelectCity);
        btnSelectCity.setOnClickListener(this);
    }

    private void initRecyclerView(String[] days, String[] temperatures) {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SocnetAdapter adapter = new SocnetAdapter(days, temperatures);
        recyclerView.setAdapter(adapter);
    }

    private String[] generateDays() {
        String[] days = new String[DAY_COUNT];
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM");
        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < DAY_COUNT; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            days[i] = dateFormatter.format(calendar.getTime());
        }

        return days;
    }

    private String[] generateTemperatures() {
        String[] temps = new String[DAY_COUNT];
        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < DAY_COUNT; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            temps[i] = "+ " + calendar.get(Calendar.DAY_OF_MONTH);
        }

        return temps;
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
        outState.putSerializable(Constants.EXTRA_CURRENT_CITY, city);
        super.onSaveInstanceState(outState);
        if (DEBUG) {
            Log.d(TAG, "onSaveInsSt()");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SETTING_CODE) {
            recreate();
        }
    }

    private String getLines(BufferedReader in) {
        return in.lines().collect(Collectors.joining("\n"));
    }

    @SuppressLint("DefaultLocale")
    private void displayWeather(WeatherRequest weatherRequest) {
        txtViewCity.setText(weatherRequest.getName());
        txtViewTemperature.setText(String.format("%.0f", weatherRequest.getMain().getTemp() - 273.15));
        txtViewPressure.setText(String.format("%.0f", weatherRequest.getMain().getPressure()/1.333));

        if (city.isNeedPressure()) {
            TextView txtViewLabelPressure = (TextView) findViewById(R.id.label_pressure);
            txtViewLabelPressure.setVisibility(View.VISIBLE);
            txtViewPressure.setVisibility(View.VISIBLE);
        }
    }
}