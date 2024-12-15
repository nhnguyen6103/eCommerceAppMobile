package com.javaproject.mobile.data.model.responses

import com.google.gson.annotations.SerializedName

data class CartResponse (
    @SerializedName("id")
    val id: String,
    @SerializedName("listItems")
    val listItems : List<ProductResponse>
)