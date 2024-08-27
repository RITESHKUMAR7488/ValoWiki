package com.example.valowiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.valowiki.databinding.RvAgentsChildBinding
import com.example.valowiki.models.Data

import android.content.Context

class AgentAdapter (
    private val list: List<Data>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
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
        val item = list[position]
        val binding = (holder as ViewHolder).binding
        Glide.with(context).load(item.fullPortrait).into(binding.agentChildImage)
        binding.agentChildName.text = item.displayName

    }
class ViewHolder(val binding: RvAgentsChildBinding) : RecyclerView.ViewHolder(binding.root){

}

}
