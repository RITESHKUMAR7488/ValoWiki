package com.example.valowiki.uis

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.valowiki.MyApplication
import com.example.valowiki.R
import com.example.valowiki.adapters.WeaponsAdapter
import com.example.valowiki.apiInterface.Api
import com.example.valowiki.databinding.ActivityWeaponsBinding
import com.example.valowiki.repositories.MyRepository
import com.example.valowiki.viewModelFactory.MyViewModelFactory
import com.example.valowiki.viewModels.MyViewModel

class Weapons : AppCompatActivity() {
    private lateinit var binding: ActivityWeaponsBinding
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= DataBindingUtil.setContentView(this,R.layout.activity_weapons)
        with(binding){
            val application = application as MyApplication
            val retrofitBuilder = application.retrofit
            val apiInterface = retrofitBuilder.create(Api::class.java)

            val repository = MyRepository(apiInterface)
            viewModel = ViewModelProvider(
                this@Weapons,
                MyViewModelFactory(repository)
            )[MyViewModel::class.java]
            val tittle = intent.getStringExtra("title")
        }

    }
    private fun getData(title:String){
        binding.title.text=title
        when(title){
            "Weapons" -> {
                viewModel.getWeapons().observe(this@Weapons) {
                    val data = it.data
                    val adapter = WeaponsAdapter(data, this@Weapons)
                    binding.rvWeapon.adapter = adapter

                    Log.d("dataaaa", "$data")

                    getData(data.toString())
                }
            }
        }
    }
}