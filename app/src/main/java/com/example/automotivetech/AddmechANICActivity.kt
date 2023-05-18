package com.example.automotivetech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.automotivetech.models.Mechanics
import com.example.automotivetech.models.Service
import com.google.firebase.database.FirebaseDatabase

class AddmechANICActivity : AppCompatActivity() {
    lateinit var mechname : EditText
    lateinit var mechlocation : EditText
    lateinit var mechphone : EditText
    lateinit var mechsave : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addmech_anicactivity)
        mechname = findViewById(R.id.medt_mechName)
        mechlocation = findViewById(R.id.medt_mechLocation)
        mechphone = findViewById(R.id.medt_mechPhone)
        mechsave = findViewById(R.id.mbtn_mechSave)
        mechsave.setOnClickListener {
            var mechName = mechname.text.toString().trim()
            var mechLocation = mechlocation.text.toString().trim()
            var mechPhone = mechphone.text.toString().trim()
            var id = System.currentTimeMillis().toString()
            if (mechName.isEmpty()){
                mechname.setError("Please fill this field")
                mechname.requestFocus()
            }else if (mechLocation.isEmpty()){
                mechlocation.setError("Please fill this field")
                mechlocation.requestFocus()
            }else if (mechPhone.isEmpty()) {
                mechphone.setError("Please fill this field")
                mechphone.requestFocus()
            }else{
                var serviceData = Mechanics(mechName, mechLocation, mechPhone, id)
                var ref = FirebaseDatabase.getInstance().getReference().child("mechanics/$id")
                ref.setValue(serviceData).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Mechanic added successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Mechanic adding failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


    }
}