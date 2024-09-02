package com.example.valowiki.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.valowiki.databinding.RvAgentsChildBinding
import com.example.valowiki.databinding.RvWeaponChildBinding
import com.example.valowiki.models.DataXXX
import com.example.valowiki.uis.Agents
import com.example.valowiki.uis.MapsDetail
import com.example.valowiki.uis.WeaponsDetail
import com.google.api.Context

class MapAdapter(private val list: List<DataXXX>,private val context: Agents):
    RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
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
       return  list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item=list[position]
        val binding=(holder as ViewHolder).binding
        binding.weaponChildName.text=item.displayName
        Glide.with(context).load(item.splash).into(binding.weaponChildImage)
        binding.itemWeaponLayout.setOnClickListener {
            val intent= Intent(context, MapsDetail::class.java)
            intent.putExtra("model",item)
            context.startActivity(intent)

        }

    }
    private class ViewHolder(val binding : RvWeaponChildBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}