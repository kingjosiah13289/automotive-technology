package com.example.automotivetech

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.automotivetech.adapters.ServicesAdapter
import com.example.automotivetech.adapters.SparepartsAdapter
import com.example.automotivetech.models.Sparepart
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ViewSparepartsActivity : AppCompatActivity() {
    lateinit var sparespartslist : ListView
    lateinit var spareparts:ArrayList<Sparepart>
    lateinit var purchase : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_spareparts)
        sparespartslist = findViewById(R.id.SparepartsList)
        purchase = findViewById(R.id.btn_purchasenow)

        spareparts = ArrayList()
        var myAdapter = SparepartsAdapter(applicationContext,spareparts)
        var progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")

        //Access the table in the database

        var my_db = FirebaseDatabase.getInstance().reference.child("Spareparts")
        //Start retrieving data
        progress.show()
        my_db.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                //Get the data and put it on the arraylist users
                spareparts.clear()
                for (snap in p0.children){
                    var spare = snap.getValue(Sparepart::class.java)
                    spareparts.add(spare!!)
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

        sparespartslist.adapter = myAdapter
        purchase.setOnClickListener {
            var purchases = Intent(this, SparepartsWebsite::class.java)
            startActivity(purchases)
}
    }
}