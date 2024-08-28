package com.example.valowiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.valowiki.adapters.AgentAdapter.ViewHolder
import com.example.valowiki.databinding.RvAgentsChildBinding
import com.example.valowiki.models.DataX
import android.content.Context
import com.example.valowiki.databinding.RvWeaponChildBinding

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
        binding.weaponChildName.text = item.displayName
    }
    class ViewHolder(val binding:RvWeaponChildBinding):RecyclerView.ViewHolder(binding.root)
}