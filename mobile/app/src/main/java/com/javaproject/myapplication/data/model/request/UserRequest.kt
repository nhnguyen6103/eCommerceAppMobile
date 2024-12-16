package com.javaproject.myapplication.data.model.request

import com.google.gson.annotations.SerializedName

data class UserRequest (
    @SerializedName("username")
    var username: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("password")
    var password: String?
)