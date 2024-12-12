package com.javaproject.mobile.data.model.responses

import com.google.gson.annotations.SerializedName

data class ProductResponse (
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("category")
    val category:String,
    @SerializedName("imageURL")
    val imageURL: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("price")
    val price: Double,
    @SerializedName("description")
    val description: String
)