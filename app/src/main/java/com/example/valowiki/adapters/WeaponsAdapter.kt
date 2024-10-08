package com.example.valowiki.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


import com.example.valowiki.models.DataX

import android.util.Log
import com.bumptech.glide.Glide
import com.example.valowiki.databinding.RvWeaponChildBinding
import com.example.valowiki.uis.AgentsDetail
import com.example.valowiki.uis.WeaponsDetail

class WeaponsAdapter(
    val list:List<DataX>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            RvWeaponChildBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        val binding = (holder as ViewHolder).binding
        Glide.with(context).load(item.displayIcon).into(binding.weaponChildImage)
        Log.d("imagesss", item.displayIcon)
        binding.weaponChildName.text = item.displayName
        binding.itemWeaponLayout.setOnClickListener {
            val intent= Intent(context, WeaponsDetail::class.java)
            intent.putExtra("model",item)
            context.startActivity(intent)

        }
    }
    class ViewHolder(val binding:RvWeaponChildBinding):RecyclerView.ViewHolder(binding.root)
}