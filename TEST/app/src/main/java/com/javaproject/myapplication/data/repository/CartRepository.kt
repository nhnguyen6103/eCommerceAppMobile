package com.javaproject.myapplication.data.repository

import com.javaproject.myapplication.data.model.request.CartRequest
import com.javaproject.myapplication.data.model.response.BaseResponse
import com.javaproject.myapplication.data.model.response.CartResponse
import com.javaproject.myapplication.data.network.CartApi
import javax.inject.Inject

class CartRepository  @Inject constructor(private val cartApi: CartApi) {
    suspend fun addToCart(
        token: String,
        request: CartRequest
    ) : BaseResponse<CartResponse?> = cartApi.addToCart(token,request)

    suspend fun getCart(
        token: String
    ) : BaseResponse<CartResponse?> = cartApi.getCart(token)

    suspend fun updateProductQuantity(
        token:String,
        request: CartRequest
    ) : BaseResponse<CartResponse?> = cartApi.updateProductQuantity(token, request)

    suspend fun deleteProduct(
        token: String,
        productID: String
    ) : BaseResponse<CartResponse?> = cartApi.deleteProduct(token, productID)
}