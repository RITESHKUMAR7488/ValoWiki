package com.example.valowiki.uis

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.valowiki.MyApplication
import com.example.valowiki.R
import com.example.valowiki.adapters.CallOutAdapter
import com.example.valowiki.apiInterface.Api
import com.example.valowiki.databinding.ActivityMapsDetailBinding
import com.example.valowiki.models.DataXXX
import com.example.valowiki.repositories.MyRepository
import com.example.valowiki.viewModelFactory.MyViewModelFactory
import com.example.valowiki.viewModels.MyViewModel

class MapsDetail : AppCompatActivity() {
    private lateinit var binding: ActivityMapsDetailBinding
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_maps_detail)
        with(binding){

            val data=intent.getSerializableExtra("model") as DataXXX
            mapDetailName.text=data.displayName
            Glide.with(this@MapsDetail).load(data.displayIcon).into(mapDetailImage)
            tacticalDescription.text=data.tacticalDescription
            coordinates.text=data.coordinates

            val application= application as MyApplication
            val retrofitBuilder=application.retrofit
            val apiInterface=retrofitBuilder.create(Api::class.java)

            val repository=MyRepository(apiInterface)
            viewModel= ViewModelProvider(
                this@MapsDetail,
                MyViewModelFactory(repository)

            )[MyViewModel::class.java]
            viewModel.getMaps()
            val adapter= CallOutAdapter(data.callouts,this@MapsDetail)
            rvMapCallout.adapter=adapter
        }
    }
}