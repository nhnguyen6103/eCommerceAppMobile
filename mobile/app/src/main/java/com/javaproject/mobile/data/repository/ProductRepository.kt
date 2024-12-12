package com.javaproject.mobile.data.repository

import com.javaproject.mobile.data.model.responses.BaseResponse
import com.javaproject.mobile.data.model.responses.ProductResponse
import com.javaproject.mobile.data.network.ProductApi
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productApi: ProductApi) {
    suspend fun getAllProducts(): BaseResponse<List<ProductResponse>> = productApi.getAllProduct()
}
