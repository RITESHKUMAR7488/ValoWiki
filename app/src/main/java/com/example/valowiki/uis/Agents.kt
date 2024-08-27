package com.example.valowiki.uis

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.valowiki.MyApplication
import com.example.valowiki.R
import com.example.valowiki.adapters.AgentAdapter
import com.example.valowiki.apiInterface.Api
import com.example.valowiki.databinding.ActivityAgentsBinding
import com.example.valowiki.repositories.MyRepository
import com.example.valowiki.viewModelFactory.MyViewModelFactory
import com.example.valowiki.viewModels.MyViewModel

class Agents : AppCompatActivity() {
    private lateinit var binding: ActivityAgentsBinding
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_agents)
        with(binding) {
            val application = application as MyApplication
            val retrofitBuilder = application.retrofit
            val apiInterface = retrofitBuilder.create(Api::class.java)

            val repository = MyRepository(apiInterface)
            viewModel = ViewModelProvider(
                this@Agents,
                MyViewModelFactory(repository)
            )[MyViewModel::class.java]
            viewModel.getAgent().observe(this@Agents){
                val data = it.data
                val adapter = AgentAdapter(data,this@Agents)
                rvAgents.adapter = adapter
            }


        }

    }
}