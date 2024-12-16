package com.javaproject.myapplication.data.network

import com.javaproject.myapplication.data.model.request.CartRequest
import com.javaproject.myapplication.data.model.response.BaseResponse
import com.javaproject.myapplication.data.model.response.CartResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface CartApi {
    @GET("cart")
    suspend fun getCart(
        @Header("Authorization")token: String,
    ) : BaseResponse<CartResponse?>

    @POST("cart")
    suspend fun addToCart(
        @Header("Authorization")token: String,
        @Body request: CartRequest
    ): BaseResponse<CartResponse?>

    @PUT("cart")
    suspend fun updateProductQuantity(
        @Header("Authorization")token: String,
        @Body request: CartRequest
    ): BaseResponse<CartResponse?>

    @DELETE("cart/{productID}")
    suspend fun deleteProduct(
        @Header("Authorization")token: String,
        @Path("productID") productID: String
    ): BaseResponse<CartResponse?>
}