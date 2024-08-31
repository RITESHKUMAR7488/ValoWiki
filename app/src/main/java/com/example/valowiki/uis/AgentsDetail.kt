package com.example.valowiki.uis

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.valowiki.MyApplication
import com.example.valowiki.R
import com.example.valowiki.adapters.AgentsAbilityDetailAdapter
import com.example.valowiki.apiInterface.Api
import com.example.valowiki.databinding.ActivityAgentsDetailBinding
import com.example.valowiki.models.Data
import com.example.valowiki.repositories.MyRepository
import com.example.valowiki.viewModelFactory.MyViewModelFactory
import com.example.valowiki.viewModels.MyViewModel

class AgentsDetail : AppCompatActivity() {
    private lateinit var binding: ActivityAgentsDetailBinding
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_agents_detail)
        with(binding){
            val data=intent.getSerializableExtra("model") as Data
            Log.d("agentData", "$data")

            val application= application as MyApplication
            val retrofitBuilder=application.retrofit
            val apiInterface=retrofitBuilder.create(Api::class.java)

            val repository=MyRepository(apiInterface)
            viewModel=ViewModelProvider(
                this@AgentsDetail,
                MyViewModelFactory(repository)
            )[MyViewModel::class.java]
            viewModel.getAgent()
            val adapter= AgentsAbilityDetailAdapter(data.abilities,this@AgentsDetail)
            rvAgentAbilityDetails.adapter=adapter

        }


    }
}