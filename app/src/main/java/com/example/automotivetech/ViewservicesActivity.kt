package com.example.automotivetech

import com.example.automotivetech.adapters.ServicesAdapter
import com.example.automotivetech.models.Service

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ViewservicesActivity : AppCompatActivity() {
    lateinit var listServices:ListView
    lateinit var otherservices : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewservices)
        listServices = findViewById(R.id.mListServices)
        otherservices = findViewById(R.id.btn_moreservices)
        var services:ArrayList<Service> = ArrayList()
        var myAdapter = ServicesAdapter(applicationContext,services)
        var progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")

        //Access the table in the database

        var my_db = FirebaseDatabase.getInstance().reference.child("Services")
        //Start retrieving data
        progress.show()
        my_db.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                //Get the data and put it on the arraylist users
                services.clear()
                for (snap in p0.children){
                    var service = snap.getValue(Service::class.java)
                    services.add(service!!)
                }
                //Notify the adapter that data has changed
                myAdapter.notifyDataSetChanged()
                progress.dismiss()
            }

            override fun onCancelled(p0: DatabaseError) {
                progress.dismiss()
                Toast.makeText(applicationContext,"DB Locked",Toast.LENGTH_LONG).show()
            }
        })

        listServices.adapter = myAdapter
        otherservices.setOnClickListener {
            var more = Intent(this, ServicesActivity::class.java)
            startActivity(more)
        }
    }
}