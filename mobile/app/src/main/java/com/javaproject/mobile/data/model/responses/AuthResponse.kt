package com.javaproject.mobile.data.model.responses

import com.google.gson.annotations.SerializedName


data class AuthResponse (
    @SerializedName("token")
    val token: String,
    @SerializedName("user")
    val user: UserResponse
)