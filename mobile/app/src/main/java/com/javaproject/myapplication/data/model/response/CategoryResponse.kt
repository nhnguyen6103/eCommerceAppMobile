package com.javaproject.myapplication.data.model.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse (
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String
)