package com.javaproject.myapplication.data.model.response

import com.google.gson.annotations.SerializedName

data class AuthResponse (
    @SerializedName("token")
    val token: String,
    @SerializedName("user")
    val user: UserResponse
)