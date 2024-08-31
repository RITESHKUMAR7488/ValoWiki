package com.example.valowiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valowiki.databinding.WeaponDeatailRangeBinding
import com.example.valowiki.models.DamageRange
import com.example.valowiki.uis.WeaponsDetail

class DamageAdapter(private val list: List<DamageRange>,private val context: WeaponsDetail):
    RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            WeaponDeatailRangeBinding.inflate(
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
        binding.rangeStart.text=item.rangeStartMeters.toString()
        binding.rangeEnd.text=item.rangeEndMeters.toString()
        binding.headDamage.text=item.headDamage.toString()
        binding.bodyDamage.text=item.bodyDamage.toString()
        binding.legDamage.text=item.legDamage.toString()
    }
    class ViewHolder(val binding: WeaponDeatailRangeBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}