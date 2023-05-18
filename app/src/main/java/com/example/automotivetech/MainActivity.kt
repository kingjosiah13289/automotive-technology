package com.example.automotivetech

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.automotivetech.models.Users
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var name : EditText
    lateinit var phone : EditText
    lateinit var email : EditText
    lateinit var vehicletype : EditText
    lateinit var platenumb : EditText
    lateinit var password : EditText
    lateinit var register : Button
    lateinit var signin : TextView
    lateinit var progressDialog: ProgressDialog
    lateinit var mAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.edt_name)
        phone = findViewById(R.id.edt_phone)
        email = findViewById(R.id.mEdtEmail)
        vehicletype = findViewById(R.id.edt_vehicletype)
        platenumb = findViewById(R.id.edt_vehPlate)
        password = findViewById(R.id.mEdtPassword)
        register = findViewById(R.id.btn_register)
        signin = findViewById(R.id.text_signin)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Registering")
        progressDialog.setMessage("Please wait...")
        mAuth = FirebaseAuth.getInstance()

        signin.setOnClickListener {
            var kurejesta = Intent(this,SigninActivity::class.java)
            startActivity(kurejesta)
        }
        register.setOnClickListener {
            var jina = name.text.toString().trim()
            var simu = phone.text.toString().trim()
            var arafa = email.text.toString().trim()
            var gari = vehicletype.text.toString().trim()
            var namba = platenumb.text.toString().trim()
            var siri = password.text.toString().trim()
            var id = System.currentTimeMillis().toString()
            if (jina.isEmpty()) {
                name.setError("Please fill this field")
                name.requestFocus()
            } else if (simu.isEmpty()) {
                phone.setError("Please fill this field")
                phone.requestFocus()
            } else if (arafa.isEmpty()) {
                email.setError("Please fill this field")
                email.requestFocus()
            } else if (gari.isEmpty()) {
                vehicletype.setError("Please fill this field")
                vehicletype.requestFocus()
            } else if (namba.isEmpty()) {
                platenumb.setError("please fill this field")
                platenumb.requestFocus()
            } else if (siri.isEmpty()) {
                password.setError("please fill this field")
                password.requestFocus()
            }else {
                // check user details for clarification and registering
                //Proceed to save
                //Prepare the user to be saved
                var user = Users(jina, simu, gari, namba, id)
                //Create a reference in the firebase database
                var ref = FirebaseDatabase.getInstance().getReference().child("Users/" + id)
                //Show the progress to start saving
                progressDialog.show()
                mAuth.createUserWithEmailAndPassword(arafa,siri).addOnCompleteListener {
                    // Dismiss the progress and check if the task was successful
                        task ->
                    progressDialog.dismiss()
                    ref.setValue(user)
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this, "User registered successfully",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(Intent(this@MainActivity,HomepageActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(
                            this, "User registering failed",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

            }
        }

    }
}