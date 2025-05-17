package com.example.skinova.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project1762.Helper.ChangeNumberItemsListener
import com.example.project1762.Helper.ManagmentCart
import com.example.skinova.Model.ItemsModel
import com.example.skinova.databinding.ViewholderCartBinding

class CartAdapter(
    private val listItem: ArrayList<ItemsModel>,
    private val context: Context,
    private val changeNumberItemsListener: ChangeNumberItemsListener
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ViewholderCartBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val managementCart = ManagmentCart(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewholderCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItem[position]

        holder.binding.apply {
            // Handle null values safely
            titleTxt.text = item.title ?: "Unnamed Item"

            // Handle null price with default value
            val price = item.price ?: 0.0
            feeEachTime.text = "$${"%.2f".format(price)}"
            totalEachTime.text = "$${"%.2f".format(price * item.numberInCart)}"

            textView6.text = item.numberInCart.toString()

            // Safe image loading with null check
            Glide.with(context)
                .load(item.picUrl?.firstOrNull())
                .into(pic)

            plusBtn.setOnClickListener {
                val currentPosition = holder.adapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                currentPosition?.let { pos ->
                    managementCart.plusItem(pos, object : ChangeNumberItemsListener {
                        override fun onChanged() {
                            notifyItemChanged(pos)
                            changeNumberItemsListener.onChanged()
                        }
                    })
                }
            }

            minusBtn.setOnClickListener {
                val currentPosition = holder.adapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                currentPosition?.let { pos ->
                    managementCart.minusItem(pos, object : ChangeNumberItemsListener {
                        override fun onChanged() {
                            notifyItemChanged(pos)
                            changeNumberItemsListener.onChanged()
                        }
                    })
                }
            }
        }
    }

    override fun getItemCount(): Int = listItem.size
}