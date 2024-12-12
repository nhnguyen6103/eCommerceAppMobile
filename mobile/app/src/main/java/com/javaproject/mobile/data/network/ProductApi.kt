package com.javaproject.mobile.data.network

import com.javaproject.mobile.data.model.responses.BaseResponse
import com.javaproject.mobile.data.model.responses.ProductResponse
import retrofit2.http.GET

interface ProductApi {
    @GET("product")
    suspend fun getAllProduct() : BaseResponse<List<ProductResponse>>
}