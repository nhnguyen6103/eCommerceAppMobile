package com.javaproject.myapplication.data.repository

import com.javaproject.myapplication.data.model.response.BaseResponse
import com.javaproject.myapplication.data.model.response.CategoryResponse
import com.javaproject.myapplication.data.network.CategoryApi
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val categoryApi: CategoryApi) {
    suspend fun getAllCategories(
    ): BaseResponse<List<CategoryResponse>> = categoryApi.getAllCategory()
}