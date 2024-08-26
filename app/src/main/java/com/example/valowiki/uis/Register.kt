package com.example.valowiki.uis

import MainActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.valowiki.R
import com.example.valowiki.databinding.ActivityRegisterBinding
import com.example.valowiki.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private var db= Firebase.firestore
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= DataBindingUtil.setContentView(this,R.layout.activity_register)
        with(binding){
            auth=FirebaseAuth.getInstance()
            btnSignUp.setOnClickListener{
                val email=binding.etEmail.text.toString()
                val password=binding.etPassword.text.toString()
                if (email.isBlank() || password.isBlank()){
                    Toast.makeText(
                        this@Register,"please fill all the blanks",Toast.LENGTH_SHORT
                    ).show()

                }
                else{
                    auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(this@Register){ task ->
                            if (task.isSuccessful){
                                Toast.makeText(
                                    this@Register,"Successfully Registered",Toast.LENGTH_SHORT

                                ).show()
                                val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
                                val editor=sharedPreferences.edit()
                                editor.putBoolean("loggedIn",true)
                                editor.apply()

                                val user= User(email,password)

                                val db= Firebase.firestore
                                db.collection("users")
                                    .add(user)
                                    .addOnSuccessListener { documentReference ->
                                        startActivity(Intent(this@Register, MainActivity::class.java))
                                        finish()
                                        Log.d(
                                            "response",
                                            "DocumentSnapshot added with ID: ${documentReference.id}"
                                        )
                                    }
                                    .addOnFailureListener { e ->
                                        Log.w("response", "Error adding document", e)
                                    }


                            }
                            else{ Toast.makeText(
                                this@Register,
                                "Sign Up Failed",
                                Toast.LENGTH_SHORT
                            ).show()

                            }

                        }
                }
            }

        }
    }
}