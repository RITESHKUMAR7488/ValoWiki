package com.example.valowiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valowiki.databinding.MapCalloutBinding
import com.example.valowiki.models.Callout
import com.example.valowiki.uis.MapsDetail

class CallOutAdapter(private val list: List<Callout>,private val context:MapsDetail):
RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            MapCalloutBinding.inflate(
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
        binding.regionName.text=item.regionName
        binding.superRegionName.text=item.superRegionName
        binding.xCoordinate.text=item.location.x.toString()
        binding.yCoordinate.text=item.location.y.toString()

    }
    private class ViewHolder(val binding: MapCalloutBinding) : RecyclerView.ViewHolder(binding.root) {}
}