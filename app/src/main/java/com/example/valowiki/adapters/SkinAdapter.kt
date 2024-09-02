package com.example.valowiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.valowiki.databinding.RvWeaponChildBinding
import com.example.valowiki.models.Skin
import com.example.valowiki.uis.WeaponsDetail

class SkinAdapter(private val list: List<Skin>,private val context:WeaponsDetail):
RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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
        val item=list[position]
        val binding=(holder as ViewHolder).binding
        Glide.with(context).load(item.displayIcon).into(binding.weaponChildImage)
        binding.weaponChildName.text=item.displayName

    }
    private class ViewHolder(val binding: RvWeaponChildBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}