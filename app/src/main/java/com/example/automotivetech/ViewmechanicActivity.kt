package com.example.automotivetech

import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.automotivetech.adapters.mechanicsAdapter
import com.example.automotivetech.models.Mechanics
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ViewmechanicActivity : AppCompatActivity() {
    lateinit var mechanicsList : ListView
    lateinit var mechanics:ArrayList<Mechanics>
    lateinit var callmechanic : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmechanic)
        mechanicsList = findViewById(R.id.mListMechanics)
        callmechanic = findViewById(R.id.btn_callmechanic)
        mechanics = ArrayList()
        var myAdapter = mechanicsAdapter(applicationContext,mechanics)
        var progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")

        //Access the table in the database

        var my_db = FirebaseDatabase.getInstance().reference.child("mechanics")
        //Start retrieving data
        progress.show()
        my_db.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                //Get the data and put it on the arraylist users
                mechanics.clear()
                for (snap in p0.children){
                    var mechanic = snap.getValue(Mechanics::class.java)
                    mechanics.add(mechanic!!)
                }
                //Notify the adapter that data has changed
                myAdapter.notifyDataSetChanged()
                progress.dismiss()
            }

            override fun onCancelled(p0: DatabaseError) {
                progress.dismiss()
                Toast.makeText(applicationContext,"DB Locked", Toast.LENGTH_LONG).show()
            }
        })

        mechanicsList.adapter = myAdapter

        callmechanic.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0711878470"))
            if (ContextCompat.checkSelfPermission(
                    this@ViewmechanicActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@ViewmechanicActivity,
                    arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
    }
}
