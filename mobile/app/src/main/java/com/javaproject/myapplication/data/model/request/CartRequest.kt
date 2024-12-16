package com.javaproject.myapplication.data.model.request

import com.google.gson.annotations.SerializedName

data class CartRequest (
    @SerializedName("productID")
    var productID: String,
    @SerializedName("quantity")
    var quantity: Int
)