package com.javaproject.myapplication.data.network

import com.javaproject.myapplication.data.model.response.BaseResponse
import com.javaproject.myapplication.data.model.response.ProductResponse
import retrofit2.http.GET

interface ProductApi {
    @GET("product")
    suspend fun getAllProduct(
    ) : BaseResponse<List<ProductResponse>>
}