package com.example.skinova.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skinova.Activity.DetailActivity
import com.example.skinova.Model.ItemsModel
import com.example.skinova.databinding.ViewholderPopularBinding

class ListFilteredAdapter(private val items: List<ItemsModel>) :
    RecyclerView.Adapter<ListFilteredAdapter.Viewholder>() {

    inner class Viewholder(val binding: ViewholderPopularBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding = ViewholderPopularBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return Viewholder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            titleTxt.text = item.title ?: "No Title"
            priceTxt.text = "$${item.price ?: "0.00"}"
            ratingTxt.text = item.rating?.toString() ?: "0.0"

            val picURL = item.picUrl?.firstOrNull()
            if (!picURL.isNullOrEmpty()) {
                Glide.with(holder.itemView.context)
                    .load(picURL)
                    .into(pic)
                root.setOnClickListener {
                    val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply {
                        putExtra("object", item)
                    }
                    ContextCompat.startActivity(holder.itemView.context, intent, null)
                }
            }
        }
    }
}
