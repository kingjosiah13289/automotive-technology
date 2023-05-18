package com.example.automotivetech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FullvehicleserviceActivity : AppCompatActivity() {
    lateinit var airfilterchange : Button
    lateinit var fuelfilter : Button
    lateinit var brakeinspection : Button
    lateinit var wheelbearing : Button
    lateinit var electricalcomponents : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullvehicleservice)
        airfilterchange = findViewById(R.id.btn_airfilter)
        fuelfilter = findViewById(R.id.btn_fuelfilter)
        brakeinspection = findViewById(R.id.btn_brakeExtension)
        wheelbearing = findViewById(R.id.btn_wheelBearing)
        electricalcomponents = findViewById(R.id.btn_ElecTest)


    }
}