package com.example.skinova.Model

import java.io.Serializable


data class ItemsModel(
    var  title: String? = null,
    var  description:String ="",
    val picUrl: List<String>? = null,
    var price:Double?=null,
    var rating:Float? = null,
    var numberInCart :Int=0,
    var showRecommended:Boolean = false,
    var categoryId:String? =""
):Serializable