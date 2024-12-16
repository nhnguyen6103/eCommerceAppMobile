package com.javaproject.myapplication.data.model.response

import com.google.gson.annotations.SerializedName

data class CartResponse (
    @SerializedName("id")
    val id: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("listItems")
    val listItems : List<ProductResponse>
)