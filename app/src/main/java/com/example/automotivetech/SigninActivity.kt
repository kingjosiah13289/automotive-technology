package com.example.automotivetech

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SigninActivity : AppCompatActivity() {
    lateinit var usersignin: Button
    lateinit var userEmail : EditText
    lateinit var userpassword : EditText
    lateinit var userregister: TextView
    lateinit var progressDialog: ProgressDialog
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        userEmail = findViewById(R.id.medt_Email)
        userpassword = findViewById(R.id.medt_Password)
        usersignin = findViewById(R.id.btn_usersSignin)
        userregister = findViewById(R.id.edt_userRegister)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Signing in")
        progressDialog.setMessage("Please wait...")
        mAuth = FirebaseAuth.getInstance()


        userregister.setOnClickListener {
            var kurejesta = Intent(this, MainActivity::class.java)
            startActivity(kurejesta)
        }
        usersignin.setOnClickListener {
            var email = userEmail.text.toString().trim()
            var password = userpassword.text.toString().trim()
            var id = System.currentTimeMillis().toString()
            if (email.isEmpty()) {
                userEmail.setError("Please fill this field")
                userEmail.requestFocus()
            } else if (password.isEmpty()) {
                userpassword.setError("Please fill this field")
                userpassword.requestFocus()
            } else  {
                progressDialog.show()
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    // Dismiss the progress and check if the task was successful
                        task ->
                    progressDialog.dismiss()
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this, "User signed in successfully",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(Intent(this@SigninActivity,HomepageActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(
                            this, "User sign in failed",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

        }
    }
}