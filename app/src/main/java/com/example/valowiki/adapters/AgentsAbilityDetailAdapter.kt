package com.example.valowiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.valowiki.databinding.AgentDetailChildBinding
import com.example.valowiki.models.Ability
import com.example.valowiki.uis.AgentsDetail

class AgentsAbilityDetailAdapter(private val list: List<Ability>, private val context: AgentsDetail) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            AgentDetailChildBinding.inflate(
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
        Glide.with(context).load(item.displayIcon).into(binding.abilityImage)
        binding.abilityName.text=item.displayName
        binding.abilityDescription.text=item.description
    }

    class ViewHolder(val binding: AgentDetailChildBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}