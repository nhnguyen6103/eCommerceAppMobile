package com.javaproject.myapplication.data.model.request

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class OrderRequest (
    @SerializedName("status")
    val status: String,

    @SerializedName("shippingAddress")
    val shippingAddress: String,

    @SerializedName("createdAt")
    val createdAt: LocalDateTime,

    @SerializedName("updateAt")
    val updateAt: LocalDateTime,

    @SerializedName("paymentMethod")
    val paymentMethod: String,

    @SerializedName("shippingMethod")
    val shippingMethod: String,

    @SerializedName("total")
    val total: Double,

    @SerializedName("orderItems")
    val orderItems: List<OrderItem>
)