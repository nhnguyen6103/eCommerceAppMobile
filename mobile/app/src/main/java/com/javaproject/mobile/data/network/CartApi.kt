package com.javaproject.mobile.data.network

import com.javaproject.mobile.data.model.requests.CartRequest
import com.javaproject.mobile.data.model.responses.BaseResponse
import com.javaproject.mobile.data.model.responses.CartResponse
import retrofit2.http.*


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