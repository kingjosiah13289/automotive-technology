package com.example.automotivetech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.automotivetech.models.Service
import com.example.automotivetech.models.Sparepart
import com.google.firebase.database.FirebaseDatabase

class AddSparepartsActivity : AppCompatActivity() {
    lateinit var spareplace: EditText
    lateinit var sparename: EditText
    lateinit var spareprice: EditText
    lateinit var sparesave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_spareparts)
        spareplace = findViewById(R.id.IntExt_spares)
        sparename = findViewById(R.id.spare_Name)
        spareprice = findViewById(R.id.spare_price)
        sparesave = findViewById(R.id.btn_spareSave)

        sparesave.setOnClickListener {
            var place = spareplace.text.toString().trim()
            var name = sparename.text.toString().trim()
            var price = spareprice.text.toString().trim()
            var id = System.currentTimeMillis().toString()
            if (place.isEmpty()) {
                spareplace.setError("Please fill this field")
                spareplace.requestFocus()
            } else if (name.isEmpty()) {
                sparename.setError("Please fill this field")
                sparename.requestFocus()}
                else if (price.isEmpty()) {
                    spareprice.setError("Please fill this field")
                    spareprice.requestFocus()
                } else {
                    var serviceData = Sparepart(place, name, price, id)
                    var ref = FirebaseDatabase.getInstance().getReference().child("Spareparts/$id")
                    ref.setValue(serviceData).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(
                                this,
                                "Spare part added successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(this, "Spare part adding failed", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
    }
