package com.javaproject.mobile.data.model.responses

import com.google.gson.annotations.SerializedName

data class CategoryResponse (
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String
)