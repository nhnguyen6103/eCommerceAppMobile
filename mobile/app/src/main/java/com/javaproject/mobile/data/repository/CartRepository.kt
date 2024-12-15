package com.javaproject.mobile.data.repository

import com.javaproject.mobile.data.model.requests.CartRequest
import com.javaproject.mobile.data.model.responses.BaseResponse
import com.javaproject.mobile.data.model.responses.CartResponse
import com.javaproject.mobile.data.network.CartApi
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