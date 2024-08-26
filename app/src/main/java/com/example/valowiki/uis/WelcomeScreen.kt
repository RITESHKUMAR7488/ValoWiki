package com.example.valowiki.uis

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.valowiki.R
import com.example.valowiki.databinding.ActivityWelcomeScreenBinding

class WelcomeScreen : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= DataBindingUtil.setContentView(this,R.layout.activity_welcome_screen)
        with(binding){
            btnSignIn.setOnClickListener {
                startActivity(android.content.Intent(this@WelcomeScreen, SignIn::class.java))
            }
            btnSignUp.setOnClickListener {
                startActivity(Intent(this@WelcomeScreen,Register::class.java))
            }


        }

    }
}