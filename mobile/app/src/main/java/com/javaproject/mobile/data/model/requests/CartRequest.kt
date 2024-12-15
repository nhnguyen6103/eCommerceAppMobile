package com.javaproject.mobile.data.model.requests

import com.google.gson.annotations.SerializedName

data class CartRequest (
    @SerializedName("productID")
    var productID: String,
    @SerializedName("quantity")
    var quantity: Int
)