package com.example.project1762.Helper

import android.content.Context
import android.widget.Toast
import com.example.skinova.Helper.TinyDB // Assuming TinyDB is in this package
import com.example.skinova.Model.ItemsModel // Assuming ItemsModel is in this package

// --- IMPORTANT ---
// Ensure ChangeNumberItemsListener is defined ONLY ONCE in your project.
// If it's defined elsewhere, REMOVE the interface declaration from this file.
// interface ChangeNumberItemsListener {
//     fun onChanged()
// }

class ManagmentCart(private val context: Context) {

    private val tinyDB = TinyDB(context)
    private val cartKey = "CartList"

    fun insertItem(newItem: ItemsModel) {
        val cartList = getCartList()
        val existingItemIndex = cartList.indexOfFirst { it.title == newItem.title }

        if (existingItemIndex != -1) {
            if (newItem.numberInCart > 0) {
                cartList[existingItemIndex].numberInCart = newItem.numberInCart
            } else {
                cartList[existingItemIndex].numberInCart = newItem.numberInCart
            }
        } else {
            if (newItem.numberInCart > 0) {
                cartList.add(newItem)
            }
        }
        saveCartList(cartList)
        Toast.makeText(context, "Cart updated", Toast.LENGTH_SHORT).show()
    }

    fun getCartList(): ArrayList<ItemsModel> {
        // Corrected based on the error: tinyDB.getListObject(key) expects only one argument.
        // The cast might still be necessary if TinyDB returns a raw list type.
        // If TinyDB is smart enough to return ArrayList<ItemsModel> directly,
        // the suppress and cast might not even be needed, but it's safer with it.
        @Suppress("UNCHECKED_CAST")
        return (tinyDB.getListObject(cartKey) as? ArrayList<ItemsModel>)
            ?: arrayListOf()
    }

    fun minusItem(position: Int, listener: ChangeNumberItemsListener) {
        val cartList = getCartList()
        if (position >= 0 && position < cartList.size) {
            val item = cartList[position]
            if (item.numberInCart > 1) {
                item.numberInCart--
            } else {
                cartList.removeAt(position)
            }
            saveCartList(cartList)
            listener.onChanged()
        }
    }

    fun plusItem(position: Int, listener: ChangeNumberItemsListener) {
        val cartList = getCartList()
        if (position >= 0 && position < cartList.size) {
            cartList[position].numberInCart++
            saveCartList(cartList)
            listener.onChanged()
        }
    }

    fun getTotalFee(): Double {
        return getCartList().sumOf {
            (it.price ?: 0.0) * (it.numberInCart ?: 0)
        }
    }

    private fun saveCartList(cartList: ArrayList<ItemsModel>) {
        tinyDB.putListObject(cartKey, cartList)
    }

    fun clearCart() {
        saveCartList(arrayListOf())
    }

    fun getItem(title: String): ItemsModel? {
        return getCartList().find { it.title == title }
    }
}