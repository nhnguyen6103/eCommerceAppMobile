package com.javaproject.mobile.data.repository

import com.javaproject.mobile.data.model.responses.BaseResponse
import com.javaproject.mobile.data.model.responses.CategoryResponse
import com.javaproject.mobile.data.model.responses.ProductResponse
import com.javaproject.mobile.data.network.CategoryApi
import com.javaproject.mobile.data.network.ProductApi
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val categoryApi: CategoryApi) {
    suspend fun getAllCategories(): BaseResponse<List<CategoryResponse>> = categoryApi.getAllCategory()
}