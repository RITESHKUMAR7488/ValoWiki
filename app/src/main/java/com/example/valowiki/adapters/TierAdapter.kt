package com.example.valowiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.valowiki.databinding.RvAgentsChildBinding
import com.example.valowiki.databinding.RvWeaponChildBinding
import com.example.valowiki.models.DataXX
import com.example.valowiki.models.Tier
import com.example.valowiki.uis.Agents

class TierAdapter(private val list: List<Tier>,private val context:Agents):
RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            RvAgentsChildBinding.inflate(
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
        binding.agentChildName.text=item.tierName
        Glide.with(context).load(item.largeIcon).into(binding.agentChildImage)

    }

    private class ViewHolder(val binding: RvAgentsChildBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}