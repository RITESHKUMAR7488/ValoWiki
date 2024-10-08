package com.example.valowiki.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valowiki.databinding.HomeEachItemBinding
import com.example.valowiki.models.HomeScreenModel
import com.example.valowiki.uis.Agents

class HomeAdapter(private val list: List<HomeScreenModel>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


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
        val currentItem = list[position]
        val viewHolder: MyViewHolder = holder as MyViewHolder
        with(viewHolder.binding){
            tvTitle.text = currentItem.title
            ivImage.setImageResource(currentItem.image)
            item.setOnClickListener {
                val intent = Intent(context, Agents::class.java)
                intent.putExtra("title", currentItem.title)
                context.startActivity(intent)

            }


        }
    }
    inner class MyViewHolder(val binding: HomeEachItemBinding):RecyclerView.ViewHolder(binding.root)
}