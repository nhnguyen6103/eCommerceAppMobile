package com.javaproject.myapplication.data.model.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<T> (
    @SerializedName("status")
    val status: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("returnCode")
    val returnCode: String?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("data")
    val data: T?
)