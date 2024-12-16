package com.javaproject.myapplication.data.repository

import com.javaproject.myapplication.data.model.response.BaseResponse
import com.javaproject.myapplication.data.model.response.ProductResponse
import com.javaproject.myapplication.data.network.ProductApi
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productApi: ProductApi) {
    suspend fun getAllProducts(

    ): BaseResponse<List<ProductResponse>> = productApi.getAllProduct()
}
