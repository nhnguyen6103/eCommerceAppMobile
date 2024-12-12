package com.javaproject.mobile.data.model.responses

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("imageURL")
    val imageURL: String
)