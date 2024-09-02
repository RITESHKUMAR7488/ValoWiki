package com.example.valowiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.valowiki.databinding.RvAgentsChildBinding
import com.example.valowiki.databinding.RvPlayerCardChildBinding
import com.example.valowiki.models.DataXXXX
import com.example.valowiki.uis.Agents

class PlayerCardAdapter(private val list: List<DataXXXX>,private val context: Agents):
RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            RvPlayerCardChildBinding.inflate(
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
        binding.playerCardName.text=item.displayName
        Glide.with(context).load(item.largeArt).into(binding.playerCardImage)

    }

    private class ViewHolder(val binding: RvPlayerCardChildBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}