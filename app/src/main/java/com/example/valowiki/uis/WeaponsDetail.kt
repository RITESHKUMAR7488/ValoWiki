package com.example.valowiki.uis

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.valowiki.MyApplication
import com.example.valowiki.R
import com.example.valowiki.adapters.DamageAdapter
import com.example.valowiki.adapters.SkinAdapter
import com.example.valowiki.apiInterface.Api
import com.example.valowiki.databinding.ActivityWeaponsDetailBinding
import com.example.valowiki.models.DataX
import com.example.valowiki.repositories.MyRepository
import com.example.valowiki.viewModelFactory.MyViewModelFactory
import com.example.valowiki.viewModels.MyViewModel

class WeaponsDetail : AppCompatActivity() {
    private lateinit var binding: ActivityWeaponsDetailBinding
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= DataBindingUtil.setContentView(this,R.layout.activity_weapons_detail)
        with(binding){
            val data=intent.getSerializableExtra("model") as DataX
            Log.d("damage detail","$data")
            Glide.with(this@WeaponsDetail).load(data.displayIcon).into(weaponDetailImage)
            weaponDetailName.text=data.displayName
            fireRate.text=data.weaponStats.fireRate.toString()
            magazineSize.text=data.weaponStats.magazineSize.toString()
            runSizeMultiplier.text=data.weaponStats.runSpeedMultiplier.toString()
            equipTimeSeconds.text=data.weaponStats.equipTimeSeconds.toString()
            reloadTime.text=data.weaponStats.reloadTimeSeconds.toString()
            firstBulletsAccuracy.text=data.weaponStats.firstBulletAccuracy.toString()
            shotgunPelletCount.text=data.weaponStats.shotgunPelletCount.toString()
            wallPenetration.text=data.weaponStats.wallPenetration
            feature.text=data.weaponStats.feature
            altFireType.text=data.weaponStats.altFireType
            zoomMultiplier.text = data.weaponStats.adsStats.zoomMultiplier.toString()
            cost.text=data.shopData.cost.toString()


            val application= application as MyApplication
            val retrofitBuilder=application.retrofit
            val apiInterface=retrofitBuilder.create(Api::class.java)

            val repository= MyRepository(apiInterface)
            viewModel=ViewModelProvider(
                this@WeaponsDetail,
                MyViewModelFactory(repository)
            )[MyViewModel::class.java]
            viewModel.getWeapons()
            val adapter= DamageAdapter(data.weaponStats.damageRanges,this@WeaponsDetail)
            rvWeaponDamageDetail.adapter=adapter

            viewModel.getWeapons()
            val adapters= SkinAdapter(data.skins,this@WeaponsDetail)
            rvWeaponSkin.adapter=adapters

        }

    }
}