package com.example.valowiki.uis

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.valowiki.R
import com.example.valowiki.models.Data

class AgentsDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agents_detail)

        val data=intent.getSerializableExtra("model") as Data

        Log.d("agentData", "$data")

    }
}