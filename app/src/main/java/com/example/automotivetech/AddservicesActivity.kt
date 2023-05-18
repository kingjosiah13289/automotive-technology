package com.example.automotivetech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.automotivetech.models.Service
import com.google.firebase.database.FirebaseDatabase

class AddservicesActivity : AppCompatActivity() {
    lateinit var edtServiceName:EditText
    lateinit var edtServiceDesc:EditText
    lateinit var btnSave:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addservices)
        edtServiceName = findViewById(R.id.mEdtServiceName)
        edtServiceDesc = findViewById(R.id.mEdtServiceDescription)
        btnSave = findViewById(R.id.mBtnSaveService)
        btnSave.setOnClickListener {
            var serviceName = edtServiceName.text.toString().trim()
            var serviceDesc = edtServiceDesc.text.toString().trim()
            var id = System.currentTimeMillis().toString()
            if (serviceName.isEmpty()){
                edtServiceName.setError("Please fill this field")
                edtServiceName.requestFocus()
            }else if (serviceDesc.isEmpty()){
                edtServiceDesc.setError("Please fill this field")
                edtServiceDesc.requestFocus()
            }else{
                var serviceData = Service(serviceName, serviceDesc,id)
                var ref = FirebaseDatabase.getInstance().getReference().child("Services/$id")
                ref.setValue(serviceData).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Service added successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Service adding failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}