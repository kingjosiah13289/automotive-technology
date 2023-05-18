package com.example.automotivetech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ServicesActivity : AppCompatActivity() {
    lateinit var fullvehicle : Button
    lateinit var maintain : Button
    lateinit var autoservice : Button
    lateinit var fuel : Button
    lateinit var insurance : Button
    lateinit var cleaning : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)
        fullvehicle = findViewById(R.id.btn_vehicleservice)
        maintain = findViewById(R.id.btn_maintainRepair)
        autoservice = findViewById(R.id.btn_autoservice)
        fuel = findViewById(R.id.btn_fuel)
        insurance = findViewById(R.id.btn_insurance)
        cleaning = findViewById(R.id.btn_cleaning)

        fullvehicle.setOnClickListener {
            var gariyote = Intent(this, FullvehicleserviceActivity::class.java)
            startActivity(gariyote)
        }
        maintain.setOnClickListener {
            var tengeneza = Intent(this, MaintainingActivity::class.java)
            startActivity(tengeneza)
        }
        autoservice.setOnClickListener {
            var auto = Intent(this, AutoserviceActivity::class.java)
            startActivity(auto)
        }
        fuel.setOnClickListener {
            var jaza = Intent(this, FuelActivity::class.java)
            startActivity(jaza)
        }
        insurance.setOnClickListener {
            var insure = Intent(this, InsuranceActivity::class.java)
            startActivity(insure)
        }
        cleaning.setOnClickListener {
            var osha = Intent(this, CleaningActivity::class.java)
            startActivity(osha)
        }

    }
}