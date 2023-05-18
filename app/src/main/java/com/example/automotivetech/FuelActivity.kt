package com.example.automotivetech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FuelActivity : AppCompatActivity() {
    lateinit var fuelstation : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fuel)
        fuelstation = findViewById(R.id.btn_fillingstation)
    }
}