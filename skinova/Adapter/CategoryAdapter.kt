package com.example.skinova.Adapter

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.skinova.Model.CtaegoryModel // Assuming CtaegoryModel is correct
import com.example.skinova.R
import com.example.skinova.databinding.ViewholderCategoryBinding
import com.example.skinova.Activity.ListActivity

class CategoryAdapter(private val items: List<CtaegoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.Viewholder>() {

    private var selectedPosition = -1


    class Viewholder(val binding: ViewholderCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding = ViewholderCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = items[position]
        holder.binding.titleTxt.text = item.title

        // Apply selected or default background/text color based on the selected position
        if (selectedPosition == position) {
            holder.binding.titleTxt.setBackgroundResource(R.drawable.blue_bg)
            holder.binding.titleTxt.setTextColor(
                ContextCompat.getColor(holder.itemView.context, R.color.white)
            )
        } else {
            holder.binding.titleTxt.setBackgroundResource(R.drawable.light_blue_bg)
            holder.binding.titleTxt.setTextColor(
                ContextCompat.getColor(holder.itemView.context, R.color.black)
            )
        }


        holder.binding.root.setOnClickListener {

            if (position != RecyclerView.NO_POSITION) {
                val previousSelectedPosition = selectedPosition
                selectedPosition = position
                notifyItemChanged(previousSelectedPosition)
                notifyItemChanged(selectedPosition)

                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(holder.itemView.context, ListActivity::class.java).apply {
                        putExtra("id", item.id.toString())
                        putExtra("title", item.title)
                    }
                    ContextCompat.startActivity(holder.itemView.context, intent, null)
                }, 1000)

            }
        }
    }

    override fun getItemCount(): Int = items.size
}