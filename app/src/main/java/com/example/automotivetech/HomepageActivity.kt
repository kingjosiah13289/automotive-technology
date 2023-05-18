package com.example.automotivetech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomepageActivity : AppCompatActivity() {
    lateinit var btnAddServices : Button
    lateinit var btnViewServices : Button
    lateinit var btnAddMechanics : Button
    lateinit var btnViewMechanics : Button
    lateinit var btnAddAutospares : Button
    lateinit var btnViewAutospares : Button
    lateinit var insurance : Button
    lateinit var ntsa : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        btnAddServices = findViewById(R.id.mBtnAddServices)
        btnViewServices = findViewById(R.id.mBtnViewServices)
        btnAddMechanics = findViewById(R.id.mBtnAddMechanic)
        btnViewMechanics = findViewById(R.id.mBtnViewMechanics)
        btnAddAutospares = findViewById(R.id.mBtnAddAutospares)
        btnViewAutospares = findViewById(R.id.mBtnViewAutospares)
        insurance = findViewById(R.id.btn_vehicleinsurance)
        ntsa = findViewById(R.id.btn_ntsaweb)


        btnAddServices.setOnClickListener {
            var all = Intent(this, AddservicesActivity::class.java)
            startActivity(all)
        }
        btnViewServices.setOnClickListener {
            var webweb = Intent(this, ViewservicesActivity::class.java)
            startActivity(webweb)
        }
        btnAddMechanics.setOnClickListener {
            var insuree = Intent(this, AddmechANICActivity::class.java)
            startActivity(insuree)
        }
        btnViewMechanics.setOnClickListener {
            var mechanic = Intent(this, ViewmechanicActivity::class.java)
            startActivity(mechanic)
        }
        btnAddAutospares.setOnClickListener {
            var nunua = Intent(this, AddSparepartsActivity::class.java)
            startActivity(nunua)
        }
        btnViewAutospares.setOnClickListener {
            var nunua = Intent(this, ViewSparepartsActivity::class.java)
            startActivity(nunua)
        }
        insurance.setOnClickListener {
            var insure = Intent(this, VehicleinsuranceWebsite::class.java)
            startActivity(insure)
        }
        ntsa.setOnClickListener {
            var transport = Intent(this, NtsawebsiteActivity::class.java)
            startActivity(transport)
        }
    }
}