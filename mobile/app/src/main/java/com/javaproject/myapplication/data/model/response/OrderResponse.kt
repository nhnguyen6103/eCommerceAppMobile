package com.javaproject.myapplication.data.model.response

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class OrderResponse (
    @SerializedName("id")
    val id: String,

    @SerializedName("total")
    val total: Double,

    @SerializedName("status")
    val status: String,

    @SerializedName("shipping_address")
    val shippingAddress: String,

    @SerializedName("createdAt")
    val createdAt: LocalDateTime,

    @SerializedName("updatedAt")
    val updatedAt: LocalDateTime,

    @SerializedName("paymentMethod")
    val paymentMethod: String,

    @SerializedName("shippingMethod")
    val shippingMethod: String,

    @SerializedName("orderedItems")
    val orderedItems: List<OrderedItemResponse>
)