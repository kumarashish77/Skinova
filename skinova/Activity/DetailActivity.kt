package com.example.skinova.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.project1762.Helper.ManagmentCart
import com.example.skinova.Adapter.PicAdapter
import com.example.skinova.Model.ItemsModel
import com.example.skinova.databinding.ActivityDetailBinding
import android.widget.Toast // Added for error handling


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var item: ItemsModel? = null // Make item nullable for safer initialization
    private lateinit var managmentCart: ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        managmentCart = ManagmentCart(this)

        if (!getBundles()) {
            // If getBundles returns false (item not found), finish the activity
            Toast.makeText(this, "Error: Item details not found.", Toast.LENGTH_LONG).show()
            finish()
            return // Stop further execution if item is null
        }
        initList()
        updateQuantityDisplay() // Initialize quantity display
    }

    private fun initList() {
        item?.let { currentItem -> // Use safe call for item
            val picList = ArrayList<String>()
            // Ensure picUrl is not null before iterating
            currentItem.picUrl?.let { urls ->
                for (imageUrl in urls) {
                    picList.add(imageUrl)
                }
            }

            if (picList.isNotEmpty()) {
                Glide.with(this)
                    .load(picList[0])
                    .into(binding.pic)

                binding.picList.adapter = PicAdapter(picList) { selectedImageUrl ->
                    Glide.with(this)
                        .load(selectedImageUrl)
                        .into(binding.pic)
                }
                binding.picList.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            } else {


            }
        }
    }

    private fun getBundles(): Boolean {

        item = intent.getSerializableExtra("object") as? ItemsModel
        if (item == null) {
            return false
        }

        item?.let { currentItem ->
            binding.titleTxt.text = currentItem.title
            binding.descriptionTxt.text = currentItem.description
            binding.priceTxt.text = "$" + currentItem.price

            binding.addToCartBtn.setOnClickListener {

                item?.let { cartItem ->

                    try {
                        cartItem.numberInCart = Integer.valueOf(binding.textView6.text.toString())
                        if (cartItem.numberInCart > 0) {
                            managmentCart.insertItem(cartItem)
                            Toast.makeText(this, "${cartItem.title} added to cart", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Please select a quantity greater than 0", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: NumberFormatException) {
                        Toast.makeText(this, "Invalid quantity", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            binding.backBtn.setOnClickListener { finish() }

            binding.plusBtn.setOnClickListener {
                item?.let {
                    it.numberInCart++
                    updateQuantityDisplay()
                }
            }

            binding.minusBtn.setOnClickListener {
                item?.let {
                    if (it.numberInCart > 0) {
                        it.numberInCart--
                        updateQuantityDisplay()
                    }
                }
            }
        }
        return true
    }

    private fun updateQuantityDisplay() {
        item?.let {
            binding.textView6.text = it.numberInCart.toString()
        }
    }
}