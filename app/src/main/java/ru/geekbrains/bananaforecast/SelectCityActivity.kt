package ru.geekbrains.bananaforecast

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelectCityActivity : AppCompatActivity(){
    var selectCity: Button? = null
    var autoCompleteCities: AutoCompleteTextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_city)

        val autoCompleteCities = findViewById<AutoCompleteTextView>(R.id.editTextCity)
        autoCompleteCities.setAdapter(ArrayAdapter(this,
            android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.cities)))

        val button = findViewById<Button>(R.id.buttonSelectCity)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}