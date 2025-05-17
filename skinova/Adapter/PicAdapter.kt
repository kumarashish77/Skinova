package com.example.skinova.Adapter

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skinova.Model.CtaegoryModel // Assuming CtaegoryModel is correct
import com.example.skinova.R
import com.example.skinova.databinding.ViewholderCategoryBinding
import com.example.skinova.Activity.ListActivity
import com.example.skinova.databinding.ViewholderPicBinding

class PicAdapter(private val items: List<String>,private val onImageSelected:(String)->Unit) :
    RecyclerView.Adapter<PicAdapter.Viewholder>() {

    private var selectedPosition = -1


    class Viewholder(val binding: ViewholderPicBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding = ViewholderPicBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = items[position]
        holder.binding.pic.loadImage(item)

        if (selectedPosition == position) {
            holder.binding.picLayout.setBackgroundResource(R.drawable.blue_bg_selected)
        } else {
            holder.binding.picLayout.setBackgroundResource(0)
        }


        holder.binding.root.setOnClickListener {

            if (position != RecyclerView.NO_POSITION) {
                val previousSelectedPosition = selectedPosition
                selectedPosition = position
                notifyItemChanged(previousSelectedPosition)
                notifyItemChanged(selectedPosition)
                onImageSelected(item)



            }
        }
    }

    override fun getItemCount(): Int = items.size

    fun ImageView.loadImage(url: String){
        Glide.with(this.context)
            .load(url)
            .into(this)
    }
}