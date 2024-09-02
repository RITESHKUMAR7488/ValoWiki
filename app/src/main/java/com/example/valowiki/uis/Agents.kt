package com.example.valowiki.uis

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valowiki.MyApplication
import com.example.valowiki.R
import com.example.valowiki.adapters.AgentAdapter
import com.example.valowiki.adapters.MapAdapter
import com.example.valowiki.adapters.PlayerCardAdapter
import com.example.valowiki.adapters.TierAdapter
import com.example.valowiki.adapters.WeaponsAdapter
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
            val tittle = intent.getStringExtra("title")

            Log.d("titele", "$tittle")

            getData(tittle!!)

        }

    }

    private fun getData(title: String) {
        binding.title.text = title
        when (title) {
            "Agents" -> {
                viewModel.getAgent().observe(this@Agents) {
                    val data = it.data
                    val adapter = AgentAdapter(data, this@Agents)
                    binding.rvAgents.adapter = adapter
                }
            }

            "Weapons" -> {
                viewModel.getWeapons().observe(this) {
                    val data = it.data
                    val adapter = WeaponsAdapter(data, this)
                    binding.rvAgents.adapter = adapter
                    binding.rvAgents.layoutManager = LinearLayoutManager(this)

                    Log.d("dataaaa", "$data")


                }
            }

            "Maps" -> {
                viewModel.getMaps().observe(this) {
                    val data = it.data
                    val adapter = MapAdapter(data, this)
                    binding.rvAgents.adapter = adapter
                    binding.rvAgents.layoutManager = LinearLayoutManager(this)
                }
            }

            "Cards" -> {
                viewModel.getCard().observe(this) {
                    val data = it.data
                    val adapter = PlayerCardAdapter(data, this)
                    binding.rvAgents.adapter = adapter

                }
            }

            "Tiers" -> {
                viewModel.getTiers().observe(this) {
                    val data = it.data.first().tiers
                    val adapter = TierAdapter(data, this)
                    binding.rvAgents.adapter = adapter


                }
            }
        }
    }
    }
