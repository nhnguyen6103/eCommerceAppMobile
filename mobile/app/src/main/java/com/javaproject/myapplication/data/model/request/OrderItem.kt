package com.javaproject.myapplication.data.model.request

import com.google.gson.annotations.SerializedName

data class OrderItem(
    @SerializedName("productID")
    val productID: String,

    @SerializedName("quantity")
    val quantity: Int,

    @SerializedName("price")
    val price: Double
)