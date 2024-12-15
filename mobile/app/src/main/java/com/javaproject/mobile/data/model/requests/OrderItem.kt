package com.javaproject.mobile.data.model.requests

import com.google.gson.annotations.SerializedName

data class OrderItem(
    val productID: String,

    @SerializedName("quantity")
    val quantity: Int,

    @SerializedName("price")
    val price: Double
)