package com.javaproject.myapplication.data.model.response

import com.google.gson.annotations.SerializedName

data class OrderedItemResponse(
    @SerializedName("product")
    val product: ProductResponse,

    @SerializedName("quantity")
    val quantity: Int,

    @SerializedName("price")
    val price: Double
)
