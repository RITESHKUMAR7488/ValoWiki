package com.example.valowiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valowiki.databinding.HomeEachItemBinding
import com.example.valowiki.models.HomeScreenModel
import com.example.valowiki.viewModels.MyViewModel

class HomeAdapter(private val list: List<HomeScreenModel>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            HomeEachItemBinding.inflate(
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
        val viewHolder: MyViewHolder = holder as MyViewHolder
        with(viewHolder.binding){
            tvTitle.text = item.title
            ivImage.setImageResource(item.image)
        }
    }
    inner class MyViewHolder(val binding: HomeEachItemBinding):RecyclerView.ViewHolder(binding.root)
}